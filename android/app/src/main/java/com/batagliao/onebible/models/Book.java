package com.batagliao.onebible.models;

import java.util.List;

public class Book {

    private int bookOrder;

    public List<Chapter> getChapters() {
        return chapters;
    }

    private List<Chapter> chapters;

    public int getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(int bookOrder) {
        this.bookOrder = bookOrder;
    }
}
