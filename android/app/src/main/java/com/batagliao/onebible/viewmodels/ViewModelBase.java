package com.batagliao.onebible.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Observable;

import com.batagliao.onebible.BibleApplication;
import com.batagliao.onebible.models.Bible;


public abstract class ViewModelBase extends BaseObservable {

    protected BibleApplication application  = BibleApplication.getInstance();
    protected Bible bible = application.currentBible.get();

}
