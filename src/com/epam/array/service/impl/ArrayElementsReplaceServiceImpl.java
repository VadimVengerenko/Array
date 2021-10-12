package com.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.service.ArrayElementsReplaceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class ArrayElementsReplaceServiceImpl implements ArrayElementsReplaceService {
    static Logger logger = LogManager.getLogger();

    public CustomArray replaceElement(CustomArray customArray, double newVal, int i) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't replace element in (CustomArray) null");
            throw new CustomArrayException("couldn't replace element in (CustomArray) null");
        }
        double[] array = customArray.getArray();
        if (i >= array.length || i < 0) {
            logger.info("array index is out of range");
            return new CustomArray(array);
        }
        array[i] = newVal;
        logger.info("element of array with index " + i + " was successfully replaced with value " + newVal);
        return new CustomArray(array);
    }

    public CustomArray replaceElementStream(CustomArray customArray, double newVal, int i) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't replace element in (CustomArray) null");
            throw new CustomArrayException("couldn't replace element in (CustomArray) null");
        }
        double[] array = customArray.getArray();
        IntStream
                .range(i, i + 1)
                .filter(j -> i > 0 && i < array.length)
                .forEach(j -> array[j] = newVal);
        logger.info("element of array with index " + i + " was successfully replaced with value " + newVal);
        return new CustomArray(array);
    }
}
