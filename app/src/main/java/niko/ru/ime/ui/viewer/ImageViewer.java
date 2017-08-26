package niko.ru.ime.ui.viewer;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import niko.ru.ime.R;
import niko.ru.ime.app.GlideApp;
import niko.ru.ime.databinding.ViewerActivityBinding;

public class ImageViewer extends AppCompatActivity {

  private ViewerActivityBinding view;
  private SimpleTarget<Drawable> target = new SimpleTarget<Drawable>() {
    @Override
    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
      view.image.setImageDrawable(resource);
    }
  };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    view = DataBindingUtil.setContentView(this, R.layout.viewer_activity);

    Bundle extras = getIntent().getExtras();
    if (extras == null) {
      return;
    }

    String title = extras.getString("title");
    String url = extras.getString("url", null);
    GlideApp.with(this).load(url).into(target);

    view.title.setText(title);
    view.close.setOnClickListener(v -> finish());
  }
}
