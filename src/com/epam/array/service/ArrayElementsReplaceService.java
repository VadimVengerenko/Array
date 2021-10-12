package com.epam.array.service;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;

public interface ArrayElementsReplaceService {
    CustomArray replaceElement(CustomArray customArray, double newVal, int i) throws CustomArrayException;

    CustomArray replaceElementStream(CustomArray customArray, double newVal, int i) throws CustomArrayException;
}
