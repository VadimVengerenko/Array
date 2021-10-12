package com.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.service.ArrayFindService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class ArrayFindServiceImpl implements ArrayFindService {
    static Logger logger = LogManager.getLogger();

    public Optional<Double> findAverageVal(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't find average value of (CustomArray) null");
            throw new CustomArrayException("couldn't find average value of (CustomArray) null");
        }
        double[] array = customArray.getArray();
        int len = array.length;
        Optional<Double> sum = findSum(customArray);
        Optional<Double> result = sum.map(doubleSum -> doubleSum / len);
        logger.info("average of array elements is " + result);
        return result;
    }

    public OptionalDouble findAverageValStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't find average value of (CustomArray) null");
            throw new CustomArrayException("couldn't find average value of (CustomArray) null");
        }
        OptionalDouble average = DoubleStream.of(customArray.getArray()).average();
        logger.info("average of array elements is " + average);
        return average;
    }

    public Optional<Double> findMin(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't find min value of (CustomArray) null");
            throw new CustomArrayException("couldn't find min value of (CustomArray) null");
        }
        double[] array = customArray.getArray();
        Optional<Double> min = Optional.empty();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                min = Optional.of(array[i]);
            } else if (min.get() > array[i]) {
                min = Optional.of(array[i]);
            }
        }
        logger.info("min element in array is " + min);
        return min;
    }

    public OptionalDouble findMinStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't find min value of (CustomArray) null");
            throw new CustomArrayException("couldn't find min value of (CustomArray) null");
        }
        OptionalDouble min = DoubleStream.of(customArray.getArray()).min();
        logger.info("min element in array is " + min);
        return min;
    }

    public Optional<Double> findMax(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't find max value of (CustomArray) null");
            throw new CustomArrayException("couldn't find max value of (CustomArray) null");
        }
        double[] array = customArray.getArray();
        Optional<Double> max = Optional.empty();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                max = Optional.of(array[i]);
            } else if (max.get() < array[i]) {
                max = Optional.of(array[i]);
            }
        }
        logger.info("max element in array is " + max);
        return max;
    }

    public OptionalDouble findMaxStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't find max value of (CustomArray) null");
            throw new CustomArrayException("couldn't find max value of (CustomArray) null");
        }
        double[] array = customArray.getArray();
        final OptionalDouble[] max = {Arrays.stream(array).findFirst()};
        DoubleStream.of(array)
                .filter(d -> d > max[0].getAsDouble())
                .forEach(d -> max[0] = OptionalDouble.of(d));
        logger.info("max element in array is " + max[0]);
        return max[0];
    }

    public Optional<Double> findSum(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't find sum of (CustomArray) null");
            throw new CustomArrayException("couldn't find sum of (CustomArray) null");
        }
        double[] array = customArray.getArray();
        Optional<Double> sum = Optional.empty();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                sum = Optional.of(array[i]);
            } else {
                sum = Optional.of(sum.get() + array[i]);
            }
        }
        logger.info("sum of array elements is " + sum);
        return sum;
    }

    public double findSumStream(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("couldn't find sum of (CustomArray) null");
            throw new CustomArrayException("couldn't find sum of (CustomArray) null");
        }
        double sum = DoubleStream.of(customArray.getArray()).sum();
        logger.info("sum of array elements is " + sum);
        return sum;
    }
}
