package com.batagliao.onebible;

import android.app.Application;
import android.databinding.ObservableField;

import com.batagliao.onebible.models.Bible;
import com.batagliao.onebible.models.BibleAddress;
import com.batagliao.onebible.util.Consts;
import com.google.gson.Gson;
import com.pixplicity.easyprefs.library.Prefs;


public class BibleApplication extends Application {


    private static BibleApplication instance;

    //private Bible currentBible;
    //private BibleAddress lastAccessedAddress;

    public final ObservableField<Bible> currentBible = new ObservableField<>();
    public final ObservableField<BibleAddress> lastAccessedAddress = new ObservableField<>();

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
            lastAccessedAddress.set(new BibleAddress());
        } else {
            Gson gson = new Gson();
            lastAccessedAddress.set(gson.fromJson(lastAccessed, BibleAddress.class));
        }

        //load bible
        try {
            currentBible.set(Bible.Load(selectedTranslation));
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: treat exception
        }

    }


    private void setLastAccessedAddress(BibleAddress value) {
        lastAccessedAddress.set(value);
        Gson gson = new Gson();
        String json = gson.toJson(lastAccessedAddress);
        Prefs.putString(Consts.LAST_ACCESSED_ADDRESS_KEY, json);
    }



}


