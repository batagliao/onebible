package com.batagliao.onebible;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.batagliao.onebible.models.Bible;
import com.batagliao.onebible.models.BibleAddress;
import com.batagliao.onebible.util.Consts;
import com.google.gson.Gson;
import com.pixplicity.easyprefs.library.Prefs;

import java.io.IOException;


public class BibleApplication extends Application {


    private static BibleApplication instance;

    private Bible currentBible;
    private BibleAddress lastAccessedAddress;

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

        //get selected bible translation
        String selectedTranslation = Prefs.getString(Consts.SELECTED_TRANSLATION_KEY, getResources().getString(R.string.defaultTranslation));

        // get last accessed address and converts it
        String lastAccessed = Prefs.getString(Consts.LAST_ACCESSED_ADDRESS_KEY, "");
        if (lastAccessed == "") {
            lastAccessedAddress = new BibleAddress();
        } else {
            Gson gson = new Gson();
            lastAccessedAddress = gson.fromJson(lastAccessed, BibleAddress.class);
        }

        //load bible
        try {
            setCurrentBible(Bible.Load(selectedTranslation));
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: treat exception
        }

    }

    public Bible getCurrentBible() {
        return currentBible;
    }

    public void setCurrentBible(Bible currentBible) {
        this.currentBible = currentBible;
    }


    public BibleAddress getLastAccessedAddress() {
        return lastAccessedAddress;
    }

    public void setLastAccessedAddress(BibleAddress value) {
        lastAccessedAddress = value;
        Gson gson = new Gson();
        String json = gson.toJson(lastAccessedAddress);
        Prefs.putString(Consts.LAST_ACCESSED_ADDRESS_KEY, json);
    }
}


