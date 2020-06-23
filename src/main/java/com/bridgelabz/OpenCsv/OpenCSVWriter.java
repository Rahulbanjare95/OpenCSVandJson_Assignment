package com.bridgelabz.OpenCsv;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {

    private static final String SAMPLE ="./object-list-sample.csv" ;

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        try (
                Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE));
        ) {
            StatefulBeanToCsv<UserDetails> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<UserDetails> UserDetails = new ArrayList<>();
            UserDetails.add(new UserDetails("Rahul Banjare ", "rahul.banjare@siliconDigital.com", "+1-1111111111", "UnitedKingdom"));
            UserDetails.add(new UserDetails("Satya Nadella", "satya.nadella@outlook.com", "+1-1111111112", "India"));

            beanToCsv.write(UserDetails);
        }
    }
}