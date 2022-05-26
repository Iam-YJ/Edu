package com.nhnacademy.parkyujin.service;

import com.nhnacademy.parkyujin.repository.WaterBill;
import java.util.Collection;

public interface WaterBillService {

    Collection<WaterBill> calculateBill(int waterUsage);
}
