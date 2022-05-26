package com.nhnacademy.parkyujin.repository;

import java.io.File;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * This class implements Bill Repository.
 * Space for storing the default rate table.
 */
@Repository
public class BasicBillRepository implements BillRepository {
    private final DataParser csvDataParser;
    private final DataParser jsonDataParser;
    private List<RawWaterBill> rawWaterBillList;
    private List<WaterBill> waterBillList;

    /**
     * @param
     * @param
     * @param
     * @param
     */
    public BasicBillRepository(DataParser csvDataParser,
                               DataParser jsonDataParser,
                               List<RawWaterBill> rawWaterBillList,
                               List<WaterBill> waterBillList) {
        this.csvDataParser = csvDataParser;
        this.jsonDataParser = jsonDataParser;
        this.rawWaterBillList = rawWaterBillList;
        this.waterBillList = waterBillList;
    }

    @Override
    public void csvLoad(File file) {
        rawWaterBillList = csvDataParser.parse(file);
    }

    @Override
    public void jsonLoad(File file) {
        rawWaterBillList = jsonDataParser.parse(file);
    }

    @Override
    // 사용량에 따른 표금 찾기
    public Collection<WaterBill> findBillByUsage(int waterUsage) {
        for (RawWaterBill rawWaterBill : rawWaterBillList) {
            if (waterUsage > rawWaterBill.getStartSection()
                &&
                waterUsage < rawWaterBill.getEndSection()) {
                waterBillList.add(
                    new WaterBill(rawWaterBill.getCity(), rawWaterBill.getSector(),
                        rawWaterBill.getUnitPrice(),
                        BigDecimal.valueOf(waterUsage)
                            .multiply(
                                BigDecimal.valueOf((Integer) rawWaterBill.getUnitPrice()))));
            }
        }

        return waterBillList;
    }
}
