package com.batagliao.onebible.models;

import java.util.ArrayList;
import java.util.List;


public class Chapter {

    public Chapter() {
        verses = new ArrayList<>();
    }

    private int chapterOrder;

    private List<Verse> verses;

    public int getChapterOrder() {
        return chapterOrder;
    }

    public List<Verse> getVerses() {
        return verses;
    }

    public void setChapterOrder(int chapterOrder) {
        this.chapterOrder = chapterOrder;
    }
}
