package com.batagliao.onebible.models.parsers;

import com.batagliao.onebible.models.Bible;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class BibleSaxParser {

    public static Bible parse(InputStream inputStream) {
        Bible b = null;

        try {
            SAXParser parser =  SAXParserFactory.newInstance().newSAXParser();
            XMLReader reader = parser.getXMLReader();
            BibleContentHandler contentHandler = new BibleContentHandler();
            reader.setContentHandler(contentHandler);
            parser.parse(inputStream, contentHandler);
            b = contentHandler.getBible();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return b;
    }

}
