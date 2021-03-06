package com.batagliao.onebible;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.batagliao.onebible.databinding.FragmentMainBinding;
import com.batagliao.onebible.interfaces.NavigationEnabledActivity;
import com.batagliao.onebible.viewmodels.MainPageViewModel;

import java.util.zip.Inflater;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    //private NavigationEnabledActivity mActivity;

    public MainActivityFragment() {
    }

    public static MainActivityFragment newInstance(){
        return new MainActivityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        FragmentMainBinding binding =  FragmentMainBinding.bind(view);

        MainPageViewModel viewModel = new MainPageViewModel();
        viewModel.pickRandomVerse();
        
        binding.setViewmodel(viewModel);
        return view;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if(context instanceof NavigationEnabledActivity) {
//            mActivity = (Nav)context;
//        }else{
//            throw new RuntimeException(context.toString()
//                    + " must implement FragmentPlaceholderActivity");
//        }
//    }

//    @Override
//    public void onDetach(){
//        super.onDetach();
//        mActivity = null;
//    }
}
