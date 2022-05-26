package com.nhnacademy.parkyujin.exception;

/**
 * This class for managing errors that do not have files when entering or output files.
 */
public class CsvIoException extends IllegalStateException {
    public CsvIoException(String s) {
        super(s);
    }
}
