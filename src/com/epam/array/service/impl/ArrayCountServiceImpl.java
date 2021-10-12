package com.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.service.ArrayCountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.stream.DoubleStream;

public class ArrayCountServiceImpl implements ArrayCountService {
    static Logger logger = LogManager.getLogger();

    public Optional<Integer> countPositive(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't count positive values in (CustomArray) null");
            throw new CustomArrayException("couldn't count positive values in (CustomArray) null");
        }
        double[] array = customArray.getArray();
        Optional<Integer> counter = Optional.empty();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                counter = Optional.of(0);
            }
            if (array[i] > 0) {
                counter = Optional.of(counter.get() + 1);
            }
        }
        logger.info(counter + " positive numbers in array");
        return counter;
    }

    public long countPositiveStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't count positive values in (CustomArray) null");
            throw new CustomArrayException("couldn't count positive values in (CustomArray) null");
        }
        long numOfPositive = DoubleStream.of(customArray.getArray())
                .filter(d -> d > 0)
                .count();
        logger.info(numOfPositive + " positive numbers in array");
        return numOfPositive;
    }

    public Optional<Integer> countNegative(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't count negative values in (CustomArray) null");
            throw new CustomArrayException("couldn't count negative values in (CustomArray) null");
        }
        double[] array = customArray.getArray();
        Optional<Integer> counter = Optional.empty();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                counter = Optional.of(0);
            }
            if (array[i] < 0) {
                counter = Optional.of(counter.get() + 1);
            }
        }
        logger.info(counter + " negative numbers in array");
        return counter;
    }

    public long countNegativeStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't count positive values in (CustomArray) null");
            throw new CustomArrayException("couldn't count positive values in (CustomArray) null");
        }
        long numOfNegative = DoubleStream.of(customArray.getArray())
                .filter(d -> d < 0)
                .count();
        logger.info(numOfNegative + " negative numbers in array");
        return numOfNegative;
    }
}
