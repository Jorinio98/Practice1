package com.AlliedTesting.Practice1CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.*;


public class No1aCommonsCSV {

    private static final  String FILEPATH = "OutPutFielsFromPractice1CSV/StudenstCommonCSV.csv";
    public static void main(String[] args)  throws IOException {

        {
            File file = new File(FILEPATH);
            try (
                    FileWriter outputfile = new FileWriter(file);


                    CSVPrinter csvPrinter = new CSVPrinter(outputfile , CSVFormat.DEFAULT
                            .withHeader("Name", "Class", "IQ", "Age" ));
            ) {
                csvPrinter.printRecord("Anna", "8a", "69", "13" );
                csvPrinter.printRecord("Sergei", "12b", "99", "17");
                csvPrinter.printRecord("Peter", "11b", "80", "15");
                csvPrinter.printRecord("Evlampii", "12c", "96", "18");
                csvPrinter.printRecord("Aristarh", "8b", "113", "14");

                csvPrinter.flush();

            }
        }
    }
}
