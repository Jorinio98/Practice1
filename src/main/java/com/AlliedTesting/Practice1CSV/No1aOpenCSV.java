package com.AlliedTesting.Practice1CSV;

import com.opencsv.CSVWriter;

import java.io.*;
import java.io.IOException;


public class No1aOpenCSV {

    private static final  String FILEPATH = "OutPutFielsFromPractice1CSV\\StudenstOpenCSV.csv";

    public static void main(String[] args) {



        // first create file object for file placed at location
        // specified by filepath
        File file = new File(FILEPATH);
        try {
            // create FileWriter object with file as parameter
//            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(new FileWriter(file), '_',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            // adding header to csv
            String[] header = { "Name", "Class", "IQ","Age" };
            writer.writeNext(header);

            // add data to csv
            String[] data1 = { "Anna", "8a", "69" ,"13"};
            writer.writeNext(data1);
            String[] data2 = { "Sergei", "12b", "99", "17" };
            writer.writeNext(data2);
            String[] data3 = { "Peter", "11b", "80","15" };
            writer.writeNext(data3);
            String[] data4 = { "Evlampii", "12c", "96" ,"18"};
            writer.writeNext(data4);
            String[] data5 = { "Aristarh", "8b", "113", "14" };
            writer.writeNext(data5);


            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

}
