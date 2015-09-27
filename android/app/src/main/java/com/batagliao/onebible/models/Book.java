package com.batagliao.onebible.models;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "b")
public class Book {

    @Attribute(name = "o")
    private int bookOrder;

    @ElementList(inline = true)
    private List<Chapter> chapters;

    public int getBookOrder() {
        return bookOrder;
    }
}
