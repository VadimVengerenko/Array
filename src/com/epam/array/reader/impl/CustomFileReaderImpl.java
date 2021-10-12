package com.epam.array.reader.impl;

import com.epam.array.exception.CustomArrayException;
import com.epam.array.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomFileReaderImpl implements CustomFileReader {
    static Logger logger = LogManager.getLogger();

    public ArrayList<String> readFile(String path) throws CustomArrayException {
        if (path == null) {
            logger.error("path is null");
            throw new CustomArrayException("path is null");
        }
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            bufferedReader.lines().forEach(strings::add);
        } catch (IOException e) {
            logger.error("file not found");
            throw new CustomArrayException("file not found");
        }
        logger.info("file \"" + path + "\" was successfully read");
        return strings;
    }
}
