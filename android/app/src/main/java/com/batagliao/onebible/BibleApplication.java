package com.batagliao.onebible;

import android.app.Application;
import android.content.res.Resources;

import com.batagliao.onebible.models.Bible;
import com.batagliao.onebible.util.Consts;
import com.pixplicity.easyprefs.library.Prefs;

import java.io.IOException;


public class BibleApplication extends Application {


    private static BibleApplication instance;

    public static BibleApplication getInstance() {
        return instance;
    }


    public Resources getAppResources() {
        return getResources();
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

        //get selected bible translation
        String selectedTranslation = Prefs.getString(Consts.SELECTED_TRANSLATION_KEY, getResources().getString(R.string.defaultTranslation));


        //load bible
        try {
            setCurrentBible(Bible.Load(selectedTranslation));
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: treat exception
        }

    }


    private Bible currentBible;

    public Bible getCurrentBible() {
        return currentBible;
    }

    public void setCurrentBible(Bible currentBible) {
        this.currentBible = currentBible;
    }
}


