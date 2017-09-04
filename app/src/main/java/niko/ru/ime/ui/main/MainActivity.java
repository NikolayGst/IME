package niko.ru.ime.ui.main;

import static niko.ru.ime.Config.SHARE;
import static niko.ru.ime.Config.THREE_D;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.github.nitrico.lastadapter.Holder;
import com.github.nitrico.lastadapter.ItemType;
import com.github.nitrico.lastadapter.LastAdapter;
import java.util.List;
import niko.ru.ime.BR;
import niko.ru.ime.Config;
import niko.ru.ime.R;
import niko.ru.ime.databinding.ActivityMainBinding;
import niko.ru.ime.databinding.MainMenuItemBinding;
import niko.ru.ime.model.Menu;
import niko.ru.ime.ui.detail.DetailActivity;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding bind;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

    initMenuList(Config.getMenuList(), bind.mainMenu);

  }

  private void initMenuList(List<Menu> menuList, RecyclerView mainMenu) {
    mainMenu.setLayoutManager(new LinearLayoutManager(this));
    new LastAdapter(menuList, BR.item)
        .map(Menu.class, new ItemType<MainMenuItemBinding>(R.layout.main_menu_item) {
          @Override
          public void onCreate(Holder<MainMenuItemBinding> holder) {
            holder.getBinding().lrItem.setOnClickListener(v -> {
              Intent intent = null;
              Menu menu = holder.getBinding().getItem();
              switch (menu.getUrl()) {
                case SHARE:
                  intent = new Intent(Intent.ACTION_SEND);
                  intent.putExtra(Intent.EXTRA_TEXT,
                      "Встановіть безкоштовний додаток \"Путівник МДПУ\" за посиланням: http://...");
                  intent.setType("text/plain");
                  break;
                case THREE_D:
                  intent = new Intent(Intent.ACTION_VIEW,
                      Uri.parse("http://www.mdpu.org.ua/new/uk/3d-.html"));
                  break;
                default:
                  intent = new Intent(MainActivity.this, DetailActivity.class);
                  intent.putExtra("title", menu.getName());
                  intent.putExtra("url", menu.getUrl());
              }
              startActivity(intent);
            });
          }
        })
        .into(mainMenu);
  }

}
