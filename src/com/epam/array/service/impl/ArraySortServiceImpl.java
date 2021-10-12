package com.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class ArraySortServiceImpl implements ArraySortService {
    static Logger logger = LogManager.getLogger();

    public CustomArray bubbleSort(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't sort (CustomArray) null with bubble method");
            throw new CustomArrayException("couldn't sort (CustomArray) null with bubble method");
        }
        double[] array = customArray.getArray();
        double temp;
        for (int i = 0; i + 1 < array.length; i++) {
            for (int j = 0; j + 1 < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        logger.info("array was successfully sorted with bubble method");
        return new CustomArray(array);
    }

    public CustomArray bubbleSortStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't sort (CustomArray) null with bubble method");
            throw new CustomArrayException("couldn't sort (CustomArray) null with bubble method");
        }
        double[] array = customArray.getArray();
        int len = array.length;
        final double[] temp = new double[1];
        IntStream
                .range(0, len - 1)
                .flatMap(i -> IntStream.range(0, len - i - 1))
                .forEach(j -> {
                    if (array[j] > array[j + 1]) {
                        temp[0] = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp[0];
                    }
                });
        logger.info("array was successfully sorted with bubble method");
        return new CustomArray(array);
    }

    public CustomArray selectionSort(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't sort (CustomArray) null with selection method");
            throw new CustomArrayException("couldn't sort (CustomArray) null with selection method");
        }
        double[] array = customArray.getArray();
        int tempIndex;
        double tempValue;
        for (int i = 0; i < array.length; i++) {
            tempIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[tempIndex]) {
                    tempIndex = j;
                }
            }
            tempValue = array[tempIndex];
            array[tempIndex] = array[i];
            array[i] = tempValue;
        }
        logger.info("array was successfully sorted with selection method");
        return new CustomArray(array);
    }

    public CustomArray selectionSortStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't sort (CustomArray) null with selection method");
            throw new CustomArrayException("couldn't sort (CustomArray) null with selection method");
        }
        double[] array = customArray.getArray();
        final int[] tempIndex = new int[1];
        int len = array.length;
        final double[] tempValue = new double[1];
        IntStream
                .range(0, len)
                .forEach(i -> {
                    tempIndex[0] = i;
                    IntStream
                            .range(i, len)
                            .filter(j -> array[j] < array[tempIndex[0]])
                            .forEach(j -> tempIndex[0] = j);
                    tempValue[0] = array[tempIndex[0]];
                    array[tempIndex[0]] = array[i];
                    array[i] = tempValue[0];
                });
        logger.info("array was successfully sorted with selection method");
        return new CustomArray(array);
    }

    public CustomArray insertionSort(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't sort (CustomArray) null with insertion method");
            throw new CustomArrayException("couldn't sort (CustomArray) null with insertion method");
        }
        double[] array = customArray.getArray();
        double tempValue;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                tempValue = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tempValue;
            }
        }
        logger.info("array was successfully sorted with insertion method");
        return new CustomArray(array);
    }

    public CustomArray insertionSortStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't sort (CustomArray) null with insertion method");
            throw new CustomArrayException("couldn't sort (CustomArray) null with insertion method");
        }
        double[] array = customArray.getArray();
        final double[] tempValue = new double[1];
        IntStream
                .range(1, array.length)
                .flatMap(i -> IntStream.range(-i, 0))
                .filter(j -> array[-j - 1] > array[-j])
                .forEach(j -> {
                    tempValue[0] = array[-j];
                    array[-j] = array[-j - 1];
                    array[-j - 1] = tempValue[0];
                });
        logger.info("array was successfully sorted with insertion method");
        return new CustomArray(array);
    }
}
