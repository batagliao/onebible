package com.batagliao.onebible.util;

import android.content.Context;
import android.content.res.Resources;

import com.batagliao.onebible.BibleApplication;
import com.batagliao.onebible.R;
import com.batagliao.onebible.models.Bible;
import com.batagliao.onebible.models.BibleAddress;
import com.batagliao.onebible.models.BookTypeEnum;
import com.batagliao.onebible.models.TestamentEnum;
import com.batagliao.onebible.models.Verse;

import org.jetbrains.annotations.NotNull;

/**
 * Created by batagliao on 10/7/15.
 */
public final class BibleHelper {

    private static final String BOOK_NAME_KEY = "Book%d";
    private static final String BOOK_ABBREV_KEY = "BookAbbrev%d";

    @NotNull
    public static String getBookName(int order) {
        String resourceName = String.format(BOOK_NAME_KEY, order);
        return ResourceHelper.getStringByName(resourceName);
    }

    @NotNull
    public static String getBookAbbrev(int order) {
        String resourceName = String.format(BOOK_ABBREV_KEY, order);
        return ResourceHelper.getStringByName(resourceName);
    }

    @NotNull
    public static String getAddressText(BibleAddress bibleAddress) {
        String address = "";

        int book = bibleAddress.getBookOrder() > 0 ? bibleAddress.getBookOrder() : 1;
        int chapter = bibleAddress.getChapterOrder() > 0 ? bibleAddress.getChapterOrder() : 1;

        String resourceName = String.format(BOOK_NAME_KEY, book);
        String bookName = ResourceHelper.getStringByName(resourceName);

        address += bookName + " " + chapter;

        if (bibleAddress.getVerses().size() == 0) {
            return address;
        }

        if (bibleAddress.getVerses().size() == 1) {
            return address += ":" + bibleAddress.getVerses().first();
        }


        //find sequence from first
        int sequenceLastIndex = 0;
        Verse[] verses = (Verse[]) bibleAddress.getVerses().toArray();
        for (int i = 1; i < verses.length; i++) {
            if (verses[i].getVerseOrder() == verses[i - 1].getVerseOrder() + 1) {
                sequenceLastIndex = i;
            } else {
                break;
            }
        }

        String verseAddresses = "" + verses[0].getVerseOrder();
        if (sequenceLastIndex > 0) {
            verseAddresses += "-" + verses[sequenceLastIndex];
        }

        for (int i = sequenceLastIndex + 1; i < verses.length; i++){
            verseAddresses += "," + verses[i];
        }

        return address + ":" + verseAddresses;
    }

    public static TestamentEnum getTestament(int bookOrder){
        if(bookOrder < 40){
            return TestamentEnum.OldTestament;
        }
        return TestamentEnum.NewTestament;
    }

    public static BookTypeEnum getBookType(int bookOrder){
        if (getTestament(bookOrder) == TestamentEnum.OldTestament)
        {
            if (bookOrder <= 5)
                return BookTypeEnum.Pentateuch;
            if (bookOrder <= 17)
                return BookTypeEnum.Historic;
            if (bookOrder <= 22)
                return BookTypeEnum.Poetic;
            //if (BookOrder <= 39)
            return BookTypeEnum.Prophetic;
        }

        //new testament
        if (bookOrder <= 43)
            return BookTypeEnum.Gospel;
        if (bookOrder <= 65)
            return BookTypeEnum.Epistle;
        return BookTypeEnum.Prophetic; //66
    }

    public static String getBookTypeText(BookTypeEnum bookType){
        Resources res = BibleApplication.getInstance().getResources();
        switch (bookType){
            case Pentateuch:
                return res.getString(R.string.Pentateuch);
            case Historic:
                return res.getString(R.string.Historic);
            case Poetic:
                return res.getString(R.string.Poetic);
            case Prophetic:
                return res.getString(R.string.Prophetic);
            case Gospel:
                return res.getString(R.string.Gospel);
            case Epistle:
                return res.getString(R.string.Epistle);
        }
        return "";
    }
}
