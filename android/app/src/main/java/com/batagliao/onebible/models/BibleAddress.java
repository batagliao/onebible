package com.batagliao.onebible.models;

import java.util.TreeSet;

public class BibleAddress {

    private int bookOrder;
    private int chapterOrder;
    private TreeSet<Integer> verses = new TreeSet<>();

    public BibleAddress() {
        bookOrder = 0;
        chapterOrder = 0;
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

    public TreeSet<Integer> getVerses() {
        return verses;
    }

    public void setVerses(TreeSet<Integer> verses) {
        this.verses = verses;
    }
}
