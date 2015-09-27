package com.batagliao.onebible.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "v")
public class Verse {

    @Attribute(name = "n")
    private int verseOrder;

    @Text
    private String text;

    public int getVerseOrder() {
        return verseOrder;
    }

    public String getText() {
        return text;
    }
}
