package com.batagliao.onebible.models;

public class Verse {

    private int verseOrder;

    private String text;

    public int getVerseOrder() {
        return verseOrder;
    }

    public String getText() {
        return text;
    }

    public void setVerseOrder(int verseOrder) {
        this.verseOrder = verseOrder;
    }

    public void setText(String text) {
        this.text = text;
    }
}
