package niko.ru.ime.ui.detail;

import static niko.ru.ime.Config.ABOUT_US;
import static niko.ru.ime.Config.ALBUM;
import static niko.ru.ime.Config.EMPLOYEES_FAC;
import static niko.ru.ime.Config.INFORMATION;
import static niko.ru.ime.Config.PHOTO;
import static niko.ru.ime.Config.SHARE;
import static niko.ru.ime.Config.TEACHERS;
import static niko.ru.ime.Config.THREE_D;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import niko.ru.ime.R;
import niko.ru.ime.common.BaseFragment;
import niko.ru.ime.databinding.ActivityDetailBinding;
import niko.ru.ime.ui.detail.fragments.AboutFragment;
import niko.ru.ime.ui.detail.fragments.ListFragment;

public class DetailActivity extends AppCompatActivity {

  private Bundle data;
  private ActivityDetailBinding bind;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bind = DataBindingUtil.setContentView(this, R.layout.activity_detail);

    handleIntentData();

  }

  private void handleIntentData() {
    BaseFragment selectedFragment = null;
    Bundle args = new Bundle();
    data = getIntent().getExtras();
    if (data != null) {
      String url = data.getString("url", "");
      switch (url) {
        case ABOUT_US:
          selectedFragment = new AboutFragment();
          break;
        case INFORMATION:
          break;
        case EMPLOYEES_FAC:
          selectedFragment = new ListFragment();
          args.putString("type", EMPLOYEES_FAC);
          selectedFragment.setArguments(args);
          break;
        case TEACHERS:
          selectedFragment = new ListFragment();
          args.putString("type", TEACHERS);
          selectedFragment.setArguments(args);
          break;
        case PHOTO:
          break;
        case ALBUM:
          break;
        case THREE_D:
          break;
        case SHARE:
          break;
      }
      showFragment(selectedFragment, bind.container.getId());
    }
  }

  /**
   * Метод для отображения заданного фрагмента
   *
   * @param baseFragment фрагмент, который будет отображаться
   * @param id id контейнера
   */
  public void showFragment(BaseFragment baseFragment, int id) {
    getSupportFragmentManager().beginTransaction()
        .replace(id, baseFragment).commit();
  }

  /**
   * Метод для отображения заданного фрагмента
   *
   * @param baseFragment фрагмент, который будет отображаться
   * @param id id контейнера
   * @param tag метка
   */
  public void showFragment(BaseFragment baseFragment, int id, String tag) {
    getSupportFragmentManager().beginTransaction()
        .replace(id, baseFragment)
        .addToBackStack(tag).commit();
  }
}
