package com.AlliedTesting.Practice1JSON;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class No3bJSONParser {

    public static void main(String[] args) {


        JSONParser parser = new JSONParser();

        try {

                        //json  является кким-то объектом
            Object obj = parser.parse(new FileReader("OutPutFielsFromPractice1JSON/company.json"));

            JSONObject jsonObject = (JSONObject) obj; // этот объект мы превращаем в json объект
            System.out.println(jsonObject);

            System.out.println("\n\n\n\n\n\n");

            // в jsonObject существует несколько вложенностей...
            JSONObject company = (JSONObject)  jsonObject.get("company"); //  company: который является JSONObject
//            System.out.println(company);

            JSONArray department = (JSONArray) company.get("department");// department: массив department-ов
//            System.out.println(department.size()); // их в нашем файле 2 штуки


             /*пройдемся по каждому department чтобы считывать данные о employee и нетолько  */
            for (int i = 0; i < department.size() ; i++) {

                System.out.println("-------department-------");
                JSONObject eachDep =  (JSONObject) department.get(i);// кажтый department(элемент массива)
                                                                    // превращаем в  JSONObject

                JSONArray employee = (JSONArray) eachDep.get("employee");// employee-ров у
//                System.out.println(employee.size());          // department несколько (массив employee-ров)

                String name = (String) eachDep.get("name");
                System.out.println(name);

                String depId = (String) eachDep.get("depId");
                System.out.println(depId);

                /* выковыриваем из employee-ров всю информацию */
                for (int j = 0; j <employee.size() ; j++) {
                    System.out.println("-----employee-----");

                    JSONObject eachEmp = (JSONObject) employee.get(j); // кажтый department(элемент массива)
                                                                      // превращаем в  JSONObject

                    String lastName =(String) eachEmp.get("lastName");
                    System.out.println(lastName);

                    String firstName = (String) eachEmp.get("firstName");
                    System.out.println(firstName);

                    String position = (String) eachEmp.get("position");
                    System.out.println(position);

                    String birthDate = (String) eachEmp.get("birthDate");
                    System.out.println(birthDate);

                    String managerId = (String) eachEmp.get("managerId");
                    System.out.println(managerId);

                    // у каждого employee есть свои скилы...(это массив скилов)
                    System.out.println("---skills---");
                    JSONArray skills = (JSONArray) eachEmp.get("skill");
                    Iterator<String> iterator = skills.iterator();

                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    System.out.println();
                }
                System.out.println();


            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
