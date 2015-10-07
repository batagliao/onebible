package com.batagliao.onebible;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.batagliao.onebible.databinding.FragmentMainBinding;
import com.batagliao.onebible.viewmodels.MainPageViewModel;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        MainPageViewModel viewModel = new MainPageViewModel();
        viewModel.pickRandomVerse();

        binding.setViewmodel(viewModel);
        return binding.getRoot();
    }
}
