package com.batagliao.onebible.helpers;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.batagliao.onebible.R;
import com.batagliao.onebible.fragments.BookSelectionFragment;

import java.lang.reflect.Type;

/**
 * Created by batagliao on 11/20/15.
 */
public final class ActivityHelper {

    public static AppCompatActivity getActivity(View view) {
        return (AppCompatActivity) view.getContext();
    }

    public static void transitionToActivityWithScene(Context activityContext, Class<? extends Activity> targetActivityClass,
                                                     View sourceView, String sharedElementName) {
        Intent intent = new Intent(activityContext, targetActivityClass);
        Activity sourceActivity = (Activity) activityContext;

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                sourceActivity, sourceView, sharedElementName);

        activityContext.startActivity(intent, options.toBundle());
    }

    public static void InsertFragment( Fragment fragment, View rootView) {
        FragmentManager fragmentManager = getActivity(rootView).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.booksScrollview, fragment);
        fragmentTransaction.commit();
    }


}
