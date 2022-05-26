package com.nhnacademy.parkyujin.service;

import com.nhnacademy.parkyujin.aspect.LoggingAspect;
import com.nhnacademy.parkyujin.repository.BillRepository;
import com.nhnacademy.parkyujin.repository.WaterBill;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BasicResultReportService implements ResultReportService {
    private final BillRepository basicBillRepository;

    public BasicResultReportService(
        BillRepository basicBillRepository) {
        this.basicBillRepository = basicBillRepository;
    }

    @Override
    public void report(int waterUsage) {
        Collection<WaterBill> waterBillList = basicBillRepository.findBillByUsage(waterUsage);
        int count = 0;
        for (WaterBill bill : waterBillList) {
            if (count < 5) {
                LoggingAspect.logger.info(bill.toString());
            }
            count += 1;
        }
    }
}
