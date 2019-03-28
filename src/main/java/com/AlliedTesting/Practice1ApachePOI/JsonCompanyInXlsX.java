package com.AlliedTesting.Practice1ApachePOI;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.Iterator;

public class JsonCompanyInXlsX {

    private static String[] columns = {"EmpId", "LastName", "FirstName", "Position","BirthDate","Skills","ManagerId"};

    public static void main(String[] args) {

        Workbook workbook = new XSSFWorkbook();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("OutPutFielsFromPractice1JSON/company.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            // в jsonObject существует несколько вложенностей...
            JSONObject company = (JSONObject)  jsonObject.get("company"); //  company: который является JSONObject

            JSONArray department = (JSONArray) company.get("department");// department: массив department-ов
                                                                        // их в нашем случае 2 штуки

            /*пройдемся по каждому department чтобы считывать данные о employee и нетолько...  */
            for (int i = 0; i < department.size() ; i++) {

                System.out.println("-------department-------");
                JSONObject eachDep = (JSONObject) department.get(i);// кажтый department(элемент массива)
                                                                    // превращаем в  JSONObject
                String depId = (String) eachDep.get("depId");
                String name = (String) eachDep.get("name");

                Sheet sheet = workbook.createSheet(name + "_" + depId); // инициализация шыта именем и айдишником

                JSONArray employee = (JSONArray) eachDep.get("employee");// employee-ров у
                // department несколько штук (массив employee-ров)

                Font headerFont = workbook.createFont();
                headerFont.setBold(true);                   // создаю стиль для Header
                headerFont.setFontHeightInPoints((short) 14);

                CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setFont(headerFont);

                Row headerRow = sheet.createRow(0);

                for (int j = 0; j < columns.length; j++) {
                    Cell cell = headerRow.createCell(j);
                    cell.setCellValue(columns[j]);         //заполняю нашу шапку(Header) значениями
                    cell.setCellStyle(headerCellStyle);
                }

                /* выковыриваем из employee-ров всю информацию */
                int rowNum = 1;
                for (int j = 0; j < employee.size(); j++) {
                    System.out.println("-----employee-----");

                    JSONObject eachEmp = (JSONObject) employee.get(j); // кажтый department(элемент массива)
                    // превращаем в  JSONObject
                    Row row = sheet.createRow(rowNum++);

                    String empId = (String) eachEmp.get("empId");
                    row.createCell(0).setCellValue(empId);
                    String lastName = (String) eachEmp.get("lastName");
                    row.createCell(1).setCellValue(lastName);
                    String firstName = (String) eachEmp.get("firstName");
                    row.createCell(2).setCellValue(firstName);
                    String position = (String) eachEmp.get("position");
                    row.createCell(3).setCellValue(position);
                    String birthDate = (String) eachEmp.get("birthDate");
                    row.createCell(4).setCellValue(birthDate);
                    String managerId = (String) eachEmp.get("managerId");
                    row.createCell(6).setCellValue(managerId);

                    // у каждого employee есть свои скилы...(это массив скилов)
                    System.out.println("---skills---");
                    JSONArray skills = (JSONArray) eachEmp.get("skill");
                    Iterator<String> iterator = skills.iterator();

                    Cell cell = row.createCell(5);
                    CellStyle cs = workbook.createCellStyle();
                    cs.setWrapText(true);                // создаем стиль для скилов
                    cell.setCellStyle(cs);              //чтобы они все поместились в ячейке
                    row.setHeightInPoints((3 * sheet.getDefaultRowHeightInPoints()));
                    sheet.autoSizeColumn(3);

                    while (iterator.hasNext()) {
                        cell.setCellValue(cell + "\n" + iterator.next());

                    }
//                     Resize all columns to fit the content size
                    for (int q = 0; q < columns.length; q++) {
                        sheet.autoSizeColumn(q);
                    }
                }
            }
            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream("OutPutFielsFromPractice1ApachePOI/Company.xlsx");
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();

            } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
