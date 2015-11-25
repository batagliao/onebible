package com.batagliao.onebible.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.batagliao.onebible.helpers.ActivityHelper;
import com.batagliao.onebible.interfaces.NavigationEnabledActivity;

import java.util.Hashtable;

/**
 * Created by batagliao on 11/24/15.
 */
public class NavigationService {
    private static NavigationService ourInstance = new NavigationService();

    public static NavigationService getInstance() {
        return ourInstance;
    }

    private NavigationService() {
    }


    private Hashtable<Context, NavigationEnabledActivity> mNavigators = new Hashtable<>();


    public void RegisterContext(Context context, NavigationEnabledActivity activity) {
        if (mNavigators.containsKey(context)) {
            throw new RuntimeException("Hashtable already contains key " + context.getClass().toString());
        }

        mNavigators.put(context, activity);
    }

    public void UnregisterContext(Context context) {
        if (mNavigators.containsKey(context)) {
            mNavigators.remove(context);
        }
    }

    public void Navigate(Context context, Fragment target) {
        if (!mNavigators.containsKey(context)) {
            throw new RuntimeException("Hashtable does not contains key" + context.getClass().toString());
        }

        //TODO: implement navigation stack

        NavigationEnabledActivity navigator = mNavigators.get(context);
        ActivityHelper.InsertFragment(target, navigator.getFragmentPlaceholder());
    }

    public void Back(){
        //TODO: implement
    }
}
