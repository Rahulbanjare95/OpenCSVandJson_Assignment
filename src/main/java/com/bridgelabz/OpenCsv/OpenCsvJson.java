package com.bridgelabz.OpenCsv;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCsvJson {
    static String CSV_PATH="./users-with-header.csv";
    static String JSON_PATH="users.json";

    public static  void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CsvToBeanBuilder<UserPojo> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(UserPojo.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<UserPojo> csvToBean = csvToBeanBuilder.build();
            List<UserPojo> userPojoList = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(userPojoList);
            FileWriter writer = new FileWriter(JSON_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
            UserPojo[] userPojoObj = gson.fromJson(br, UserPojo[].class);
            List<UserPojo> pojoList = Arrays.asList(userPojoObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
