package com.AlliedTesting.Practice1XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class No2bDOMQuery {

    public static void main(String argv[]) {

        try {

            File fXmlFile = new File("OutPutFielsFromPractice1XML/Company");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); // вывод рута
            System.out.println("_____________________________________");

            NodeList qById = doc.getElementsByTagName("employee");// выделил все ноды employee
                                                                    // в один нодлист qById
            for (int temp = 0; temp <qById.getLength() ; temp++) {

                Node query = qById.item(temp);
                int i=0;

                if (query.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) query;


                    System.out.println("Employee ID :"                //выводим всю информацию о работнике
                            +eElement.getAttribute("empId"));   //включая его id
                    System.out.println( "Employe : "+ "No"+ ( i=i+1 )
                            + eElement.getElementsByTagName("lastName").item(0).getTextContent()
                            + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Birth Date :"
                            + eElement.getElementsByTagName("birthDate").item(0).getTextContent());
                    System.out.println("Position :"
                            + eElement.getElementsByTagName("position").item(0).getTextContent());
                    System.out.println("managerId :"
                            + eElement.getElementsByTagName("managerId").item(0).getTextContent());



                }


                System.out.println("_____________________________________");
            }
        }catch (Exception e) {

            e.printStackTrace();
        }


    }
}
