package test.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.service.impl.ArraySortServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySortServiceImplTest {
    private final ArraySortServiceImpl sortService = new ArraySortServiceImpl();

    @Test
    public void bubbleSortTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = sortService.bubbleSort(customArray);
        CustomArray expected = new CustomArray(new double[]{-11, -8, 4, 5, 15});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void bubbleSortNullTest() {
        assertThrows(CustomArrayException.class, () -> sortService.bubbleSort(null));
    }

    @Test
    public void bubbleSortStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = sortService.bubbleSortStream(customArray);
        CustomArray expected = new CustomArray(new double[]{-11, -8, 4, 5, 15});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void bubbleSortStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> sortService.bubbleSortStream(null));
    }

    @Test
    public void selectionSortTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = sortService.selectionSort(customArray);
        CustomArray expected = new CustomArray(new double[]{-11, -8, 4, 5, 15});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void selectionSortNullTest() {
        assertThrows(CustomArrayException.class, () -> sortService.selectionSort(null));
    }

    @Test
    public void selectionSortStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = sortService.selectionSortStream(customArray);
        CustomArray expected = new CustomArray(new double[]{-11, -8, 4, 5, 15});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void selectionSortStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> sortService.selectionSortStream(null));
    }

    @Test
    public void insertionSortTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = sortService.insertionSort(customArray);
        CustomArray expected = new CustomArray(new double[]{-11, -8, 4, 5, 15});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void insertionSortNullTest() {
        assertThrows(CustomArrayException.class, () -> sortService.insertionSort(null));
    }

    @Test
    public void insertionSortStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = sortService.insertionSortStream(customArray);
        CustomArray expected = new CustomArray(new double[]{-11, -8, 4, 5, 15});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void insertionSortStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> sortService.insertionSortStream(null));
    }
}