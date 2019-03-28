package com.AlliedTesting.Practice1XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandlerParser extends DefaultHandler {


    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bPosition = false;                 //создаю boolean флаги для тегов определенных в файле company
    boolean bBirthDate = false;
    boolean bManagerId = false;
    boolean bSkill = false;
    int i=0;


    @Override
    public void startElement(String uri,               //переопределяю метод startElement наследуемый из DefaultHandler
                             String localName, String qName, Attributes attributes) throws SAXException {


        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("_____________________________________");
            String empId = attributes.getValue("empId");        // вывожу empId
            System.out.println("empId : " + empId);
            i=0;
        } else if (qName.equalsIgnoreCase("firstname")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("lastname")) {
            bLastName = true;                                            // меняю триггеры на true если тэг был найден
        } else if (qName.equalsIgnoreCase("position")) {
            bPosition = true;
        } else if (qName.equalsIgnoreCase("birthDate")) {
            bBirthDate = true;
        }else if (qName.equalsIgnoreCase("managerId")) {
            bManagerId = true;
        }

        if (qName.equalsIgnoreCase("skills")) {
            System.out.println("----------------------------------");
        }else if (qName.equalsIgnoreCase("skill")) {
            bSkill = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("End Element :" + qName);
        }
                                                                // когда находим завершающий тег ,
                                                                // выводим данную инфу на экран
        if (qName.equalsIgnoreCase("skills")) {
            System.out.println("End Element :" + qName);
            System.out.println("----------------------------------");
        }

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bFirstName) {        // т.к значение флагов true (тэг с определенным именем существует) => мы можем
            System.out.println("First Name: "                                 // достать из него необходимую инфу
                    + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bPosition) {
            System.out.println("Position : " + new String(ch, start, length));
            bPosition = false;
        } else if (bBirthDate) {
            System.out.println("Birth Date: " + new String(ch, start, length));
            bBirthDate = false;
        } else if (bManagerId) {
            System.out.println("Manager Id: " + new String(ch, start, length));
            bManagerId = false;
        }

        if (bSkill) {
            System.out.println("Skill: " + (i=i+1) + ") "
                    + new String(ch, start, length));
            bSkill = false;
        }
    }
}