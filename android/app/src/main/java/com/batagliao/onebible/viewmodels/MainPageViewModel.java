package com.batagliao.onebible.viewmodels;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.view.View;

import com.batagliao.onebible.BR;
import com.batagliao.onebible.R;
import com.batagliao.onebible.fragments.BookSelectionFragment;
import com.batagliao.onebible.models.Book;
import com.batagliao.onebible.models.Chapter;
import com.batagliao.onebible.models.Verse;
import com.batagliao.onebible.util.BibleHelper;
import com.batagliao.onebible.util.NavigationService;

import java.util.Random;

/**
 * Created by batagliao on 9/18/15.
 */
public class MainPageViewModel extends ViewModelBase {

    private String mainVerseText = "";
    private String mainVerseBookAbbrev = "";
    private int mainVerseChapter = 0;
    private int mainVerseOrder = 0;

    public MainPageViewModel() {
        // if currentBible change, all properties must be rebound
        application.currentBible.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                notifyChange();
            }
        });

        application.lastAccessedAddress.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                notifyPropertyChanged(BR.startOrContinueTitleText);
                notifyPropertyChanged(BR.startOrContinueDetailText);
            }
        });
    }

    public void pickRandomVerse() {
        Random rand = new Random();

        int iBook = rand.nextInt(bible.getBooks().size());
        Book book = bible.getBooks().get(iBook);

        int iChapter = rand.nextInt(book.getChapters().size());
        Chapter chapter = book.getChapters().get(iChapter);

        int iVerse = rand.nextInt(chapter.getVerses().size());
        Verse verse = chapter.getVerses().get(iVerse);

        setMainVerseText(verse.getText());
        setMainVerseBookAbbrev(book.getBookAbbrev());
        setMainVerseChapter(chapter.getChapterOrder());
        setMainVerseOrder(verse.getVerseOrder());
    }

    @Bindable
    public String getMainVerseText() {
        return mainVerseText;
    }

    public void setMainVerseText(String mainVerseText) {
        if (this.mainVerseText != mainVerseText) {
            this.mainVerseText = mainVerseText;
            notifyPropertyChanged(BR.mainVerseText);
        }
    }

    @Bindable
    public String getMainVerseBookAbbrev() {
        return mainVerseBookAbbrev;
    }

    public void setMainVerseBookAbbrev(String mainVerseBookAbbrev) {
        if (this.mainVerseBookAbbrev != mainVerseBookAbbrev) {
            this.mainVerseBookAbbrev = mainVerseBookAbbrev;
            notifyPropertyChanged(BR.mainVerseBookAbbrev);
        }
    }

    @Bindable
    public int getMainVerseChapter() {
        return mainVerseChapter;
    }

    public void setMainVerseChapter(int mainVerseChapter) {
        if (this.mainVerseChapter != mainVerseChapter) {
            this.mainVerseChapter = mainVerseChapter;
            notifyPropertyChanged(BR.mainVerseChapter);
        }
    }

    @Bindable
    public int getMainVerseOrder() {
        return mainVerseOrder;
    }

    public void setMainVerseOrder(int mainVerseOrder) {
        if (this.mainVerseOrder != mainVerseOrder) {
            this.mainVerseOrder = mainVerseOrder;
            notifyPropertyChanged(BR.mainVerseOrder);
        }
    }

    @Bindable
    public String getBibleName(){
        return bible.getTitle();
    }

    @Bindable
    public String getStartOrContinueTitleText(){
        if(application.lastAccessedAddress.get().getBookOrder() == 0){
            return application.getString(R.string.main_startreading);
        }else{
            return application.getString(R.string.main_continuereading);
        }
    }

    @Bindable
    public String getStartOrContinueDetailText(){
        return BibleHelper.getAddressText(application.lastAccessedAddress.get());
    }

    public void onClickBooks(View view){
//        ActivityHelper.transitionToActivityWithScene(view.getContext(), BooksActivity.class,
//                view, "books");

        BookSelectionFragment fragment = BookSelectionFragment.newIntance();
        NavigationService.getInstance().Navigate(view.getContext(), fragment);

//        FragmentPlaceholderActivity activity = (FragmentPlaceholderActivity) view.getContext();
//        activity.PlaceFragment(fragment);
    }
}
