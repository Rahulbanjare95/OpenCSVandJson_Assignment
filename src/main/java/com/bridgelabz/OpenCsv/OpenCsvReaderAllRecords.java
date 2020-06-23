package com.bridgelabz.OpenCsv;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCsvReaderAllRecords {

    static String CSV_PATH="./users.csv";

    public static void main(String[] args) throws IOException {
        Reader read = Files.newBufferedReader(Paths.get(CSV_PATH));
        CSVReader reader=new CSVReader(read);
        List<String[]> recordsList=reader.readAll();
        for (String[] records:recordsList) {
            System.out.println("Name: " + records[0]);
            System.out.println("Email: " + records[1]);
            System.out.println("Phone: " + records[2]);
            System.out.println("Country: " + records[3]);
        }
    }
}
