package com.bridgelabz.OpenCsv;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVtoPojoParser {

    static String CSV_USER_WITH_HEADER="./users-with-header.csv";

    public static void main(String[] args) throws IOException {
        try (Reader filereader = Files.newBufferedReader(Paths.get(CSV_USER_WITH_HEADER));
        ){
        CsvToBean csvToBean = new CsvToBeanBuilder(filereader).withType(UserPojo.class)
                    .withIgnoreLeadingWhiteSpace(true).build();
            Iterator<UserPojo> csvUserPojoIterator=csvToBean.iterator();
            while (csvUserPojoIterator.hasNext()){
                UserPojo userPojo=csvUserPojoIterator.next();
                System.out.println("Name : " +userPojo.getName());
                System.out.println("Email : " +userPojo.getEmail());
                System.out.println("Phone : " +userPojo.getPhoneNo());
                System.out.println("Country : " +userPojo.getCountry());
            }
        }
    }
}
