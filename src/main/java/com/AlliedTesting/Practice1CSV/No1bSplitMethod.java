package com.AlliedTesting.Practice1CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class No1bSplitMethod {

        public static void main(String[] args) {

            String csvFile = "OutPutFielsFromPractice1CSV\\StudenstOpenCSV.csv";
            String line = "";
            String cvsSplitBy = "_";
            int HeaderOfFie = 0 ;

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null)  {

                    if(HeaderOfFie >0) {
                        HeaderOfFie++;

                        // use comma as separator
                        String[] Student = line.split(cvsSplitBy);

                        System.out.println("Student [Name= " + Student[0] + " , IQ=" + Student[2] + "]");
                    }
                    HeaderOfFie++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
