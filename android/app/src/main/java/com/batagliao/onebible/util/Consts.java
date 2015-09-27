package com.batagliao.onebible.util;

public final class Consts {

    public static final String SELECTED_TRANSLATION_KEY = "selectedTranslation";

    public static final String BIB_FILE_EXTENSION = ".bib";
    public static final String BIB_FOLDER = "bibs";

    /**
     The caller references the constants using <tt>Consts.EMPTY_STRING</tt>,
     and so on. Thus, the caller should be prevented from constructing objects of
     this class, by declaring this private constructor.
     */
    private Consts(){
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }

}
