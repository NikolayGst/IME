package niko.ru.ime.ui.main;

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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
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
              Menu menu = holder.getBinding().getItem();
              Intent intent = new Intent(MainActivity.this, DetailActivity.class);
              intent.putExtra("url", menu.getUrl());
              startActivity(intent);
            });
          }
        })
        .into(mainMenu);
  }

}
