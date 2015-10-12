package com.batagliao.onebible.util;

import android.content.Context;
import android.content.res.Resources;

import com.batagliao.onebible.BibleApplication;

/**
 * Created by batagliao on 10/7/15.
 */
public final class BibleHelper {

    private static final String BOOK_NAME_KEY = "Book%d";
    private static final String BOOK_ABBREV_KEY = "BookAbbrev%d";

    public static String getBookName(int order){
        Resources resource = BibleApplication.getInstance().getResources();
        String resourceName = String.format(BOOK_NAME_KEY, order);
        int id = resource.getIdentifier(resourceName, "string", "com.batagliao.onebible");
        return resource.getString(id);
    }

    public static String getBookAbbrev(int order){
        Resources resource = BibleApplication.getInstance().getResources();
        String resourceName = String.format(BOOK_ABBREV_KEY, order);
        int id = resource.getIdentifier(resourceName, "string", "com.batagliao.onebible");
        return resource.getString(id);
    }

}