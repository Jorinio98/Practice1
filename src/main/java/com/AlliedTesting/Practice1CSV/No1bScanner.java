package com.AlliedTesting.Practice1CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class No1bScanner {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("OutPutFielsFromPractice1CSV/StudenstOpenCSV.csv "));

        scanner.useDelimiter("_");

        while (scanner.hasNext()){

            System.out.print(scanner.next() + " \to_o ^_^ o_o\t  " );
        }

        scanner.close();
    }
}
