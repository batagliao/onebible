package com.batagliao.onebible.viewmodels;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableList;

import com.batagliao.onebible.BR;
import com.batagliao.onebible.BibleApplication;
import com.batagliao.onebible.models.Book;

import java.util.List;

/**
 * Created by batagliao on 11/20/15.
 */
public class BooksSelectionViewModel extends ViewModelBase {

    public BooksSelectionViewModel() {
        application.currentBible.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                notifyPropertyChanged(BR.bibleName);
            }
        });
    }

    @Bindable
    public String getBibleName(){
        return bible.getTitle();
    }

    @Bindable
    public List<Book> getBooks(){
        return BibleApplication.getInstance().currentBible.get().getBooks();
    }
}

