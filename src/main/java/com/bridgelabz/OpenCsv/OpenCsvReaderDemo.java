package com.bridgelabz.OpenCsv;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
public class OpenCsvReaderDemo {
    static final String CSV_PATH="./users.csv";
    public static void main(String[] args) {
        try(
            Reader read= Files.newBufferedReader(Paths.get(CSV_PATH));
            CSVReader csvReader=new CSVReader(read);
        ){
            String [] records;
            while ((records=csvReader.readNext())!=null){
                System.out.println("Name: "+records[0]);
                System.out.println("Email: "+records[1]);
                System.out.println("Phone: "+records[2]);
                System.out.println("Country: "+records[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
