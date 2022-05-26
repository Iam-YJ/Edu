package com.nhnacademy.parkyujin.repository;

import java.math.BigDecimal;

/**
 * This class to save parsed data.
 */
public class WaterBill {
    private final String city;
    private final String sector;
    private final int unitPrice;
    private BigDecimal billTotal;

    public WaterBill(String city, String sector, int unitPrice, BigDecimal billTotal) {
        this.city = city;
        this.sector = sector;
        this.unitPrice = unitPrice;
        this.billTotal = billTotal;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(BigDecimal billTotal) {
        this.billTotal = billTotal;
    }

    @Override
    public String toString() {
        return "WaterBill{" +
            "city='" + city + '\'' +
            ", sector='" + sector + '\'' +
            ", unitPrice=" + unitPrice +
            ", billTotal=" + billTotal +
            '}';
    }
}
