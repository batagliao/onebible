package com.batagliao.onebible.models;


import com.batagliao.onebible.BibleApplication;
import com.batagliao.onebible.util.Consts;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.InputStream;
import java.util.List;

@Root(name = "bible")
public class Bible {

    @Element(name = "title")
    private String name;

    @ElementList(inline = true)
    private List<Book> books;

    public static Bible Load(String name) throws Exception {

        //TODO: improve performance
        String filename = Consts.BIB_FOLDER + "/" + name + Consts.BIB_FILE_EXTENSION;
        InputStream iS = null;
        try {
            iS = BibleApplication.getInstance().getAssets().open(filename);

            Serializer serializer = new Persister();
            return serializer.read(Bible.class, iS);
        }
        finally {
            iS.close();
        }

    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
