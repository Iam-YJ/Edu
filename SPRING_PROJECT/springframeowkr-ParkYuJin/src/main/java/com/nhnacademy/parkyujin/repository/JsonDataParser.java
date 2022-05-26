package com.nhnacademy.parkyujin.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.parkyujin.exception.CsvFileIsNotExistException;
import com.nhnacademy.parkyujin.exception.CsvIoException;
import com.nhnacademy.parkyujin.main.BootStrap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * This class for parsing json files.
 */
@Service
public class JsonDataParser implements DataParser {
    private final List<RawWaterBill> rawWaterBillList = new ArrayList<>();

    @Override
    public List<RawWaterBill> parse(File file) {

        File jsonFile =new File(
            getClass().getClassLoader().getResource("data/Tariff_20220331.json").getFile());

        try {
            System.out.println("jsonFile : "  + jsonFile);
//            String line;
//            int lineCount = 0;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                if (lineCount > 0) {
//                    String[] rawWaterBills = line.split(",");
//                    rawWaterBillList.add(
//                        new RawWaterBill(rawWaterBills[1], rawWaterBills[2], // 지자체명, 업종
//                            Integer.parseInt(rawWaterBills[4]), // 구간 시작
//                            Integer.parseInt(rawWaterBills[5]), // 구간 끝
//                            Integer.parseInt(rawWaterBills[6]))); // 구간 금액
//                }
//                lineCount += 1;
//            }

            ObjectMapper objectMapper = new ObjectMapper();
            RawWaterBill rawWaterBill = objectMapper.readValue(jsonFile, RawWaterBill.class);
//            System.out.println("=== rawWaterBill ===");
//            System.out.println(rawWaterBill);

        } catch (FileNotFoundException e) {
            throw new CsvFileIsNotExistException("json file is not exist");
        } catch (IOException e) {
            throw new CsvIoException("There is a problem IO the json file");
        }
        return rawWaterBillList;
    }
}
