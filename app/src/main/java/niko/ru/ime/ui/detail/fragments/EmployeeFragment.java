package niko.ru.ime.ui.detail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import niko.ru.ime.R;
import niko.ru.ime.app.GlideApp;
import niko.ru.ime.common.BaseFragment;
import niko.ru.ime.databinding.FragmentEmployeeBinding;

public class EmployeeFragment extends BaseFragment {


  private static final String NAME = "name";
  private static final String DESC = "desc";
  private static final String URL = "url";

  private String name;
  private String desc;
  private String url;

  private FragmentEmployeeBinding view;


  public EmployeeFragment() {
    // Required empty public constructor
  }

  public static EmployeeFragment newInstance(String name, String desc, String url) {
    EmployeeFragment fragment = new EmployeeFragment();
    Bundle args = new Bundle();
    args.putString(NAME, name);
    args.putString(DESC, desc);
    args.putString(URL, url);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      name = getArguments().getString(NAME);
      desc = getArguments().getString(DESC);
      url = getArguments().getString(URL);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = FragmentEmployeeBinding.inflate(inflater, container, false);

    view.title.setText(name);

    view.desc.setText(desc);

    GlideApp.with(this).load(url).placeholder(R.drawable.placeholder).centerCrop().into(view.image);

    view.image.setOnClickListener(v -> showImage(name, url));

    return view.getRoot();
  }

}
