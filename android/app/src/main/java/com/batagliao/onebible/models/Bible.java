package com.batagliao.onebible.models;


import com.batagliao.onebible.BibleApplication;
import com.batagliao.onebible.models.parsers.BibleSaxParser;
import com.batagliao.onebible.util.Consts;

import java.io.InputStream;
import java.util.List;

public class Bible {

    private List<Book> books;



    private String title;

    public static Bible Load(String name) throws Exception {

        //TODO: improve performance
        String filename = Consts.BIB_FOLDER + "/" + name + Consts.BIB_FILE_EXTENSION;
        InputStream iS = null;
        try {
            iS = BibleApplication.getInstance().getAssets().open(filename);
            return BibleSaxParser.parse(iS);
        }
        finally {
            iS.close();
        }

    }

    public String getTitle() {
        return title;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
