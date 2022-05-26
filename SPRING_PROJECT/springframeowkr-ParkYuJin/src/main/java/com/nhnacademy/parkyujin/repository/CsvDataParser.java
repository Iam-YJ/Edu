package com.nhnacademy.parkyujin.repository;

import com.nhnacademy.parkyujin.exception.CsvFileIsNotExistException;
import com.nhnacademy.parkyujin.exception.CsvIoException;
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
 * This class for parsing csv files.
 */
@Service
public class CsvDataParser implements DataParser {
    private final List<RawWaterBill> rawWaterBillList = new ArrayList<>();

    @Override
    public List<RawWaterBill> parse(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line;
            int lineCount = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (lineCount > 0) {
                    String[] rawWaterBills = line.split(",");
                    rawWaterBillList.add(
                        new RawWaterBill(rawWaterBills[1], rawWaterBills[2], // 지자체명, 업종
                            Integer.parseInt(rawWaterBills[4]), // 구간 시작
                            Integer.parseInt(rawWaterBills[5]), // 구간 끝
                            Integer.parseInt(rawWaterBills[6]))); // 구간 금액
                }
                lineCount += 1;
            }

        } catch (FileNotFoundException e) {
            throw new CsvFileIsNotExistException("csv file is not exist");
        } catch (IOException e) {
            throw new CsvIoException("There is a problem IO the csv file");
        }
        return rawWaterBillList;
    }
}
