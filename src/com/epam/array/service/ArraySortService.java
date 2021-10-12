package com.epam.array.service;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;

public interface ArraySortService {
    CustomArray bubbleSort(CustomArray customArray) throws CustomArrayException;

    CustomArray bubbleSortStream(CustomArray customArray) throws CustomArrayException;

    CustomArray selectionSort(CustomArray customArray) throws CustomArrayException;

    CustomArray selectionSortStream(CustomArray customArray) throws CustomArrayException;

    CustomArray insertionSort(CustomArray customArray) throws CustomArrayException;

    CustomArray insertionSortStream(CustomArray customArray) throws CustomArrayException;
}
