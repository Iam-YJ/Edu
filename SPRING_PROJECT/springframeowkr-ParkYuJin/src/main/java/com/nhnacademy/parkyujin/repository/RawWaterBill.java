package com.nhnacademy.parkyujin.repository;

/**
 * This class to save csv file immediately.
 */
public class RawWaterBill {
    private final String city;
    private final String sector;
    private final int startSection;
    private final int endSection;
    private final int unitPrice;

    /**
     * @param
     * @param
     * @param
     * @param
     * @param
     */
    public RawWaterBill(String city, String sector, int startSection, int endSection,
                          int unitPrice) {
        this.city = city;
        this.sector = sector;
        this.startSection = startSection;
        this.endSection = endSection;
        this.unitPrice = unitPrice;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getStartSection() {
        return startSection;
    }

    public int getEndSection() {
        return endSection;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
