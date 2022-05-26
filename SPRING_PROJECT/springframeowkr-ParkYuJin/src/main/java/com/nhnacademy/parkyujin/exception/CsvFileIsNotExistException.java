package com.nhnacademy.parkyujin.exception;

import java.io.FileNotFoundException;

/**
 * This class for managing errors that do not have files when loading files.
 */
public class CsvFileIsNotExistException extends IllegalStateException {
    public CsvFileIsNotExistException(String s) {
        super(s);
    }
}
