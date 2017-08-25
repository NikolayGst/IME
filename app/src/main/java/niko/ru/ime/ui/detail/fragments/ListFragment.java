package niko.ru.ime.ui.detail.fragments;


import static niko.ru.ime.Config.EMPLOYEES_FAC;
import static niko.ru.ime.Config.TEACHERS;
import static niko.ru.ime.Config.getEmployeeFacList;

import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.nitrico.lastadapter.LastAdapter;
import niko.ru.ime.BR;
import niko.ru.ime.R;
import niko.ru.ime.common.BaseFragment;
import niko.ru.ime.databinding.FragmentAboutBinding;
import niko.ru.ime.databinding.FragmentListBinding;
import niko.ru.ime.model.Employee;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends BaseFragment {

  FragmentListBinding view;

  private Bundle args;


  public ListFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    view = FragmentListBinding.inflate(inflater, container, false);

    view.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

    handleTypeList();

    return view.getRoot();
  }

  private void handleTypeList() {
    if (getArguments() != null) {
      args = getArguments();
      String type = args.getString("type", "");
      switch (type) {
        case EMPLOYEES_FAC:
          new LastAdapter(getEmployeeFacList(), BR.item).map(Employee.class, R.layout.employee_list)
              .into(view.recycler);
          break;
        case TEACHERS:
          break;
      }
    }
  }


  @BindingAdapter("app:setImage")
  public static void setImage(ImageView image, String url) {
    Glide.with(image.getContext()).load(url).into(image);
  }

}
