package niko.ru.ime.ui.detail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import niko.ru.ime.R;
import niko.ru.ime.common.BaseFragment;
import niko.ru.ime.databinding.FragmentAboutBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends BaseFragment {

  private FragmentAboutBinding view;


  public AboutFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    view = FragmentAboutBinding.inflate(inflater, container, false);

    view.text.setText(getString(R.string.about_desc));
    // Inflate the layout for this fragment
    return view.getRoot();
  }

}
