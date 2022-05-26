package com.nhnacademy.parkyujin.repository;

import java.io.File;
import java.util.List;

/**
 * DataParser interface.
 */
public interface DataParser {

    List<RawWaterBill> parse(File file);
}
