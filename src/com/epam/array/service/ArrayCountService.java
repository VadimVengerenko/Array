package com.epam.array.service;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;

import java.util.Optional;

public interface ArrayCountService {
    Optional<Integer> countPositive(CustomArray customArray) throws CustomArrayException;

    long countPositiveStream(CustomArray customArray) throws CustomArrayException;

    Optional<Integer> countNegative(CustomArray customArray) throws CustomArrayException;

    long countNegativeStream(CustomArray customArray) throws CustomArrayException;
}
