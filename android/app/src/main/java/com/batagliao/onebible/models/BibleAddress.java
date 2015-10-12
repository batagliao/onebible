package com.batagliao.onebible.models;

import java.util.ArrayList;
import java.util.List;

public class BibleAddress {

    private int bookOrder;
    private int chapterOrder;
    private List<Integer> verses = new ArrayList<>();

    public BibleAddress() {
        bookOrder = 1;
        chapterOrder = 1;
    }

    public int getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(int bookOrder) {
        this.bookOrder = bookOrder;
    }

    public int getChapterOrder() {
        return chapterOrder;
    }

    public void setChapterOrder(int chapterOrder) {
        this.chapterOrder = chapterOrder;
    }

    public List<Integer> getVerses() {
        return verses;
    }

    public void setVerses(List<Integer> verses) {
        this.verses = verses;
    }
}
