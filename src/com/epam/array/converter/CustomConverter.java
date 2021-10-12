package com.epam.array.converter;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;

import java.util.ArrayList;
import java.util.Optional;

public interface CustomConverter {
    CustomArray stringsToArray(ArrayList<String> strings) throws CustomArrayException;

    Optional<Double> stringToDouble(String str) throws CustomArrayException;

    double[] arrayListToArray(ArrayList<Double> doubles) throws CustomArrayException;

    double[] arrayListToArrayStream(ArrayList<Double> doubles) throws CustomArrayException;
}