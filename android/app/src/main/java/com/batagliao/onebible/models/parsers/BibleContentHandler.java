package com.batagliao.onebible.models.parsers;

import com.batagliao.onebible.models.Bible;
import com.batagliao.onebible.models.Book;
import com.batagliao.onebible.models.Chapter;
import com.batagliao.onebible.models.Verse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BibleContentHandler extends DefaultHandler {

    private Bible bible;

    private String tempVal;
    private boolean elementOn = false;
    private Book currentBook;
    private Chapter currentChapter;
    private Verse currentVerse;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reset
        tempVal = "";

        if (localName.equalsIgnoreCase("bible")) {
            bible = new Bible();
            //read attributes
        }

        if (localName.equalsIgnoreCase("title")) {
            elementOn = true;
        }

        if (localName.equalsIgnoreCase("b")) { //book
            currentBook = new Book();
            int order = Integer.parseInt(attributes.getValue("o")); //order
            currentBook.setBookOrder(order);
        }

        if (localName.equalsIgnoreCase("c")) { //chapter
            currentChapter = new Chapter();
            int number = Integer.parseInt(attributes.getValue("n")); //number
            currentChapter.setChapterOrder(number);
        }

        if(localName.equalsIgnoreCase("v")) { //verse
            elementOn = true;
            currentVerse = new Verse();
            int number = Integer.parseInt(attributes.getValue("n")); //number
            currentVerse.setVerseOrder(number);
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementOn) {
            tempVal = new String(ch, start, length);
            elementOn = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementOn = false;

        if (localName.equalsIgnoreCase("title")) {
            bible.setTitle(tempVal);
        }

        if (localName.equalsIgnoreCase("b")) { //book
            bible.getBooks().add(currentBook);
            currentBook = null;
        }

        if(localName.equalsIgnoreCase("c")) { //chapter
            currentBook.getChapters().add(currentChapter);
            currentChapter = null;
        }

        if(localName.equalsIgnoreCase("v")) { //verse
            currentChapter.getVerses().add(currentVerse);
            currentVerse.setText(tempVal);
            currentVerse = null;
        }
    }


    public Bible getBible() {
        return bible;
    }
}
