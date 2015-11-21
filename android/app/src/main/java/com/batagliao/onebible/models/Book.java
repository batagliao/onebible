package com.batagliao.onebible.models;

import android.databinding.Bindable;

import com.batagliao.onebible.util.BibleHelper;

import java.util.ArrayList;
import java.util.List;

public class Book {

    public Book() {
        chapters = new ArrayList<>();
    }

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

    public String getBookName(){
        return BibleHelper.getBookName(bookOrder);
    }

    public String getBookAbbrev(){
        return BibleHelper.getBookAbbrev(bookOrder);
    }
}
