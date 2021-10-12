package com.epam.array.service;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;

import java.util.Optional;
import java.util.OptionalDouble;

public interface ArrayFindService {
    Optional<Double> findAverageVal(CustomArray customArray) throws CustomArrayException;

    OptionalDouble findAverageValStream(CustomArray customArray) throws CustomArrayException;

    Optional<Double> findMin(CustomArray customArray) throws CustomArrayException;

    OptionalDouble findMinStream(CustomArray customArray) throws CustomArrayException;

    Optional<Double> findMax(CustomArray customArray) throws CustomArrayException;

    OptionalDouble findMaxStream(CustomArray customArray) throws CustomArrayException;

    Optional<Double> findSum(CustomArray customArray) throws CustomArrayException;

    double findSumStream(CustomArray customArray) throws CustomArrayException;
}
