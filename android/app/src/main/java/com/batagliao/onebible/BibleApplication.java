package com.batagliao.onebible;

import android.app.Application;

import com.batagliao.onebible.util.Consts;
import com.pixplicity.easyprefs.library.Prefs;


public class BibleApplication extends Application {


    private static BibleApplication instance;

    public static BibleApplication getInstance() {
        return instance;
    }


    public void onCreate() {
        super.onCreate();
        instance = this;

        //start preferences
        new Prefs.Builder()
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        String selectedTranslation = Prefs.getString(Consts.SELECTED_TRANSLATION_KEY, String.valueOf(R.string.defaultTranslation));



        //load settings
        //load bible
    }
}


