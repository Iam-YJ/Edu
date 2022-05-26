package com.nhnacademy.parkyujin.service;

import com.nhnacademy.parkyujin.repository.BillRepository;
import com.nhnacademy.parkyujin.repository.WaterBill;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BasicWaterBillService implements WaterBillService {
    private final BillRepository basicBillRepository;

    public BasicWaterBillService(BillRepository basicBillRepository) {
        this.basicBillRepository = basicBillRepository;
    }

    @Override
    public Collection<WaterBill> calculateBill(int waterUsage) {
        return basicBillRepository.findBillByUsage(waterUsage);
    }
}
