package com.batagliao.onebible.util;

import android.content.res.Resources;

import com.batagliao.onebible.BibleApplication;

import org.jetbrains.annotations.NotNull;

/**
 * Created by batagliao on 10/26/15.
 */
public final class ResourceHelper {

    @NotNull
    public static String getStringByName(String resourceName){
        Resources resource = BibleApplication.getInstance().getResources();
        int id = resource.getIdentifier(resourceName, "string", "com.batagliao.onebible");
        return resource.getString(id);
    }

}
