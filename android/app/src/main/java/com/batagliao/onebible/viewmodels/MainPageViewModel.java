package com.batagliao.onebible.viewmodels;

import android.databinding.Bindable;

import com.batagliao.onebible.BR;
import com.batagliao.onebible.BibleApplication;
import com.batagliao.onebible.models.Book;
import com.batagliao.onebible.models.Chapter;
import com.batagliao.onebible.models.Verse;

import java.util.Random;

/**
 * Created by batagliao on 9/18/15.
 */
public class MainPageViewModel extends ViewModelBase {

    private String mainVerseText = "";

    private String startOrContinueTitleText = "";

    private String startOrContinueDetailText = "";

    private String BibleName = "";

    @Bindable
    public String getMainVerseText() {
        return mainVerseText;
    }

    public void setMainVerseText(String mainVerseText) {
        this.mainVerseText = mainVerseText;
        notifyPropertyChanged(BR.mainVerseText);
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
    }
}
