package niko.ru.ime.ui.detail.fragments;


import static niko.ru.ime.Config.ABOUT_US;
import static niko.ru.ime.Config.EMPLOYEES_FAC;
import static niko.ru.ime.Config.INFO_KAF;
import static niko.ru.ime.Config.TEACHERS;
import static niko.ru.ime.Config.getAlbumPhoto;
import static niko.ru.ime.Config.getAuditorPhoto;
import static niko.ru.ime.Config.getEmployeeFacList;
import static niko.ru.ime.Config.getKafList;
import static niko.ru.ime.Config.getTeacherList;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.github.nitrico.lastadapter.Holder;
import com.github.nitrico.lastadapter.ItemType;
import com.github.nitrico.lastadapter.LastAdapter;
import niko.ru.ime.BR;
import niko.ru.ime.Config;
import niko.ru.ime.R;
import niko.ru.ime.app.GlideApp;
import niko.ru.ime.common.BaseFragment;
import niko.ru.ime.databinding.EmployeeItemBinding;
import niko.ru.ime.databinding.FragmentDetailBinding;
import niko.ru.ime.databinding.InfoKafItemBinding;
import niko.ru.ime.databinding.PhotoAuditorItemBinding;
import niko.ru.ime.model.Employee;
import niko.ru.ime.model.Kafedra;
import niko.ru.ime.model.Photo;
import niko.ru.ime.ui.detail.DetailActivity;
import niko.ru.ime.ui.viewer.ImageViewer;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment {

  private FragmentDetailBinding view;
  private LastAdapter adapter;
  private int containerId;

  private Bundle args;

  private ItemType<EmployeeItemBinding> employeeItemType = new ItemType<EmployeeItemBinding>(
      R.layout.employee_item) {
    @Override
    public void onCreate(Holder<EmployeeItemBinding> holder) {
      holder.getBinding().avatar.setOnClickListener(v -> {
        Employee item = holder.getBinding().getItem();
        if (!item.getUrlAvatar().equals("")) {
          showImage(item.getUsername(), item.getUrlAvatar());
        }
      });
      holder.getBinding().rlItem.setOnClickListener(v -> {
        Employee item = holder.getBinding().getItem();
        showFragment(EmployeeFragment
            .newInstance(item.getUsername(), item.getShortDesc() + "\n" + item.getFullDesc(),
                item.getUrlAvatar()), containerId);
      });
    }
  };

  private ItemType<PhotoAuditorItemBinding> photoItemType = new ItemType<PhotoAuditorItemBinding>(
      R.layout.photo_auditor_item) {
    @Override
    public void onCreate(Holder<PhotoAuditorItemBinding> holder) {
      holder.getBinding().getRoot().setOnClickListener(v -> {
        Photo photo = holder.getBinding().getPhoto();
        showImage(photo.getDesc(), photo.getUrl());
      });
    }
  };

  public DetailFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    view = FragmentDetailBinding.inflate(inflater, container, false);

    view.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

    containerId = ((DetailActivity) getActivity()).getBind().container.getId();

    handleTypeList();

    return view.getRoot();
  }

  private void handleTypeList() {
    if (getArguments() != null) {
      args = getArguments();
      String type = args.getString("url", "");
      setTitle(args.getString("title"));
      switch (type) {
        case INFO_KAF:
          adapter = new LastAdapter(getKafList(), BR.item)
              .map(Kafedra.class, new ItemType<InfoKafItemBinding>(R.layout.info_kaf_item) {
                @Override
                public void onCreate(Holder<InfoKafItemBinding> holder) {
                  holder.getBinding().lrItem.setOnClickListener(v -> {
                    Kafedra kaf = holder.getBinding().getItem();
                    showFragment(KafFragment.newInstance(kaf.getName(), kaf.getDesc()),
                        containerId);
                  });

                }
              });
          break;
        case EMPLOYEES_FAC:
          adapter = new LastAdapter(getEmployeeFacList(), BR.item)
              .map(Employee.class, employeeItemType);
          break;
        case TEACHERS:
          adapter = new LastAdapter(getTeacherList(), BR.item)
              .map(String.class, R.layout.title_teacher_item)
              .map(Employee.class, employeeItemType);
          break;
        case Config.PHOTO_AUDITOR:
          view.recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
          adapter = new LastAdapter(getAuditorPhoto(), BR.photo)
              .map(Photo.class, photoItemType);
          break;
        case Config.ALBUM:
          view.recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));

          adapter = new LastAdapter(getAlbumPhoto(), BR.photo)
              .map(Photo.class, photoItemType);
          break;
      }
      adapter.into(view.recycler);
    }
  }


  @BindingAdapter("app:setImage")
  public static void setImage(ImageView image, String url) {
    GlideApp.with(image).load(url).placeholder(R.drawable.placeholder)
        .centerCrop().circleCrop().into(image);
  }


  @BindingAdapter("app:setAuditorImage")
  public static void setAuditorImage(ImageView image, String url) {
    GlideApp.with(image).load(url).placeholder(R.color.colorPrimary)
        .centerCrop().into(image);
  }


}
