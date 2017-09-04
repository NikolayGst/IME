package niko.ru.ime.ui.detail.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import niko.ru.ime.R;
import niko.ru.ime.common.BaseFragment;
import niko.ru.ime.databinding.FragmentKafBinding;

public class KafFragment extends BaseFragment {

  private static final String TITLE = "title";
  private static final String DESC = "desc";

  private String title;
  private String desc;


  private FragmentKafBinding view;


  public KafFragment() {
    // Required empty public constructor
  }

  public static KafFragment newInstance(String title, String desc) {
    KafFragment fragment = new KafFragment();
    Bundle args = new Bundle();
    args.putString(TITLE, title);
    args.putString(DESC, desc);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      title = getArguments().getString(TITLE);
      desc = getArguments().getString(DESC);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = FragmentKafBinding.inflate(inflater, container, false);

    setTitle(title);

    view.title.setText(title);
    view.desc.setText(desc);

    return view.getRoot();
  }

}
