package com.batagliao.onebible.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


@Root(name = "c")
public class Chapter {

    @Attribute(name = "n")
    private int chapterOrder;

    @ElementList(inline = true)
    private List<Verse> verses;

    public int getChapterOrder() {
        return chapterOrder;
    }

    public List<Verse> getVerses() {
        return verses;
    }
}
