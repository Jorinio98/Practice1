package com.AlliedTesting.Practice1CSV;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class No1bOpenCSV {

    public static void main(String[] args) {

        String csvFile = "OutPutFielsFromPractice1CSV\\StudenstOpenCSV.csv";
        CSVReader reader = null;


        try {
            reader = new CSVReader(new FileReader(csvFile),'_' );
            String[] Student;
            while ((Student = reader.readNext()) != null) {
                System.out.println("Student[Age= " + Student[2] + " , class= " + Student[1] + " , Name=" + Student[0] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();


        }
    }
}