package com.AlliedTesting.Practice1XML;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class  No2cSAXQuery  {

    public static void main(String[] args) {

        try {
            File inputFile = new File("OutPutFielsFromPractice1XML/Company");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandlerParser userhandler = new UserHandlerParser();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


