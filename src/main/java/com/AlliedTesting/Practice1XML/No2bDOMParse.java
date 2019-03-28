package com.AlliedTesting.Practice1XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class No2bDOMParse {

    public static void main(String argv[]) {

        try {

            File fXmlFile = new File("OutPutFielsFromPractice1XML/Company");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); // вывод рута

            NodeList nListDep = doc.getElementsByTagName("department"); // выделил все ноды department
            // в один нодлист nListDep

            System.out.println("_____________________________________");


            for (int temp = 0; temp < nListDep.getLength(); temp++) {

                Node nNodeDep = nListDep.item(temp);         // выделяю отдельный нод dep
                // который буду выводить на экран
                System.out.println("\nCurrent Element :" + nNodeDep.getNodeName());

                if (nNodeDep.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNodeDep;          // превращаю его  в элемент
                    // и вывожу его атрибуты на экран

                    System.out.println("\nDepartment :" + eElement.getAttribute("name")
                            +  "\nDepId :" + eElement.getAttribute("depId"));
                }

                System.out.println("\n--------employeers--------\n");

                NodeList nListEmp = doc.getElementsByTagName("employee");  //создаю коллкцию нодов emploee
                int i=0;
                for (int tempEmp = 0; tempEmp < nListEmp.getLength(); tempEmp++) {


                    Node nNodeEmp = nListEmp.item(tempEmp);
                    // проверяю если они
                    if(nNodeEmp.getParentNode() == nNodeDep){      // принадлежат  текущему родителю dep
                        //то мы будем с ними работать

                        Element eElement = (Element) nNodeEmp;

                        // вывот всей инфы о employee-рах
                        System.out.println( "Employe : "+ "No"+ ( i=i+1 )
                                + eElement.getElementsByTagName("lastName").item(0).getTextContent()
                                + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                        System.out.println("Birth Date :"
                                + eElement.getElementsByTagName("birthDate").item(0).getTextContent());
                        System.out.println("Position :"
                                + eElement.getElementsByTagName("position").item(0).getTextContent());
                        System.out.println("managerId :"
                                + eElement.getElementsByTagName("managerId").item(0).getTextContent());


                        // у каждого employer есть скилы..
                        System.out.println("-------skills-------");
                        NodeList nListSkills = doc.getElementsByTagName("skills");  // создадим коллекцию всех скилов всех эмплоеров

                        for (int tempSkl = 0; tempSkl < nListSkills.getLength(); tempSkl++) {

                            Node nNodeSkl = nListSkills.item(tempSkl);

                            if (nNodeSkl.getParentNode() == nNodeEmp) {// проверим является ли данный набор скилов ,ребенком текущего нода родителя employee



                                Element eElementSk = (Element) nNodeSkl;          // превращаю его  в элемент

                                System.out.println(
                                        "1)" +eElementSk.getElementsByTagName("skill").item(0).getTextContent() +     // вывожу все скиллы текущего
                                                "\n2)" +eElementSk.getElementsByTagName("skill").item(1).getTextContent() +   // эмплоера на экран
                                                "\n3)" +eElementSk.getElementsByTagName("skill").item(2).getTextContent() + "\n"
                                );
                            }

                        }
                    }





                }



                System.out.println("_____________________________________");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
