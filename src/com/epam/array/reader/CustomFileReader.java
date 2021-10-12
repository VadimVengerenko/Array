package com.epam.array.reader;

import com.epam.array.exception.CustomArrayException;

import java.util.ArrayList;

public interface CustomFileReader {
    ArrayList<String> readFile(String path) throws CustomArrayException;
}
