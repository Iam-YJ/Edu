package com.nhnacademy.parkyujin.repository;

import java.io.File;
import java.util.Collection;

/**
 * BillRepository interface.
 */
public interface BillRepository {
    void csvLoad(File file);

    void jsonLoad(File file);

    Collection<WaterBill> findBillByUsage(int waterUsage);
}
