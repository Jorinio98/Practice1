package com.AlliedTesting.Practice1XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;



public class No2bDOMCreate {

    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            //создаем рут company
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            // в company создаем нод department
            Element department = doc.createElement("department");
            rootElement.appendChild(department);

            // у department атрибут Development
            Attr depAttr = doc.createAttribute("name");
            depAttr.setValue("Testing");
            department.setAttributeNode(depAttr);

            // у department атрибут depId
            Attr depAttr2 = doc.createAttribute("depId");
            depAttr2.setValue("3");
            department.setAttributeNode(depAttr2);

            //в department создаем нод employee
            Element employee = doc.createElement("employee");
            Attr empAttr = doc.createAttribute("empId");
            empAttr.setValue("001");
            department.appendChild(employee);

            Element lastName = doc.createElement("lastName");
            lastName.appendChild(doc.createTextNode("Vladimir"));
            employee.appendChild(lastName);

            Element firstName = doc.createElement("firstName");
            firstName.appendChild(doc.createTextNode("Primac"));
            employee.appendChild(firstName);

            Element position = doc.createElement("position");
            position.appendChild(doc.createTextNode("MegaTester"));
            employee.appendChild(position);

            Element birthDate = doc.createElement("birthDate");
            birthDate.appendChild(doc.createTextNode("01.01.1945"));
            employee.appendChild(birthDate);

            Element skills = doc.createElement("skills");
            employee.appendChild(skills);

            Element skill = doc.createElement("skill");
            skill.appendChild(doc.createTextNode("level upping"));
            skills.appendChild(skill);

            Element skill2 = doc.createElement("skill");
            skill2.appendChild(doc.createTextNode("standup skills"));
            skills.appendChild(skill2);

            Element skill3 = doc.createElement("skill");
            skill3.appendChild(doc.createTextNode("learning testing"));
            skills.appendChild(skill3);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("OutPutFielsFromPractice1XML/dep3"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}