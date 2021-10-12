package com.epam.array.main;

import com.epam.array.converter.CustomConverter;
import com.epam.array.converter.impl.CustomConverterImpl;
import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.reader.CustomFileReader;
import com.epam.array.reader.impl.CustomFileReaderImpl;
import com.epam.array.service.ArrayCountService;
import com.epam.array.service.ArrayElementsReplaceService;
import com.epam.array.service.ArrayFindService;
import com.epam.array.service.ArraySortService;
import com.epam.array.service.impl.ArrayCountServiceImpl;
import com.epam.array.service.impl.ArrayElementsReplaceServiceImpl;
import com.epam.array.service.impl.ArrayFindServiceImpl;
import com.epam.array.service.impl.ArraySortServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomFileReader fileReader = new CustomFileReaderImpl();
        ArrayCountService countService = new ArrayCountServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();
        ArrayFindService findService = new ArrayFindServiceImpl();
        ArrayElementsReplaceService replaceService = new ArrayElementsReplaceServiceImpl();
        try {
            ArrayList<String> strings = fileReader.readFile("./input/input.txt");
            CustomConverter customConverter = new CustomConverterImpl();
            CustomArray customArray = customConverter.stringsToArray(strings);
            countService.countPositiveStream(customArray);
            CustomArray newCustomArray = sortService.selectionSort(customArray);
            double[] newDoubles = newCustomArray.getArray();
            customArray.hashCode();
            newCustomArray.hashCode();
            customArray.setArray(newDoubles);
            customArray.hashCode();
            newCustomArray.hashCode();
            customArray.equals(newCustomArray);
            findService.findAverageValStream(customArray);
            replaceService.replaceElement(customArray, 150, 5);
        } catch (CustomArrayException e) {
            e.printStackTrace();
        }
    }
}
