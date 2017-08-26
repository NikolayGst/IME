package niko.ru.ime.common;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.Toast;
import niko.ru.ime.R;

public class BaseFragment extends Fragment {

  /**
   * Метод для отображения заданного фрагмента
   *
   * @param baseFragment фрагмент, который будет отображаться
   * @param id id контейнера
   */
  public void showFragment(BaseFragment baseFragment, int id) {
    getFragmentManager().beginTransaction()
        .replace(id, baseFragment)
        .addToBackStack("stack").commit();
  }

  public void setTitle(String title) {
    Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
    toolbar.setTitle(title);
    toolbar.setNavigationIcon(R.mipmap.ic_back);
    toolbar.setNavigationOnClickListener(v -> {
      if (getFragmentManager().getBackStackEntryCount() == 0) {
        getActivity().finish();
      } else {
        getFragmentManager().popBackStack();
      }
    });
  }

  /**
   * Метод для отображения заданного фрагмента
   *
   * @param baseFragment фрагмент, который будет отображаться
   * @param id id контейнера
   * @param tag метка
   */
  public void showFragment(BaseFragment baseFragment, int id, String tag) {
    getFragmentManager().beginTransaction()
        .replace(id, baseFragment)
        .addToBackStack(tag).commit();
  }

  public void showToast(String msg) {
    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
  }

  public void showInWebView(WebView web, String body) {
    String strBody = "<html>"
        + "<head></head>"
        + "<style type='text/css'>body{text-align:justify;line-height:25px;}</style>"
        + "<body>"
        + body
        + "</body>"
        + " </html>  ";
    web.loadDataWithBaseURL("", strBody, "text/html", "UTF-8", "");
  }

  //Проверка на активность фрагмента в активности
  public boolean isFragmentUIActive() {
    return isAdded() && !isDetached() && !isRemoving();
  }
}
