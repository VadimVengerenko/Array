package test.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.service.impl.ArrayElementsReplaceServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayElementsReplaceServiceImplTest {
    private final ArrayElementsReplaceServiceImpl replaceService = new ArrayElementsReplaceServiceImpl();

    @Test
    public void replaceElementTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = replaceService.replaceElement(customArray, 500, 3);
        CustomArray expected = new CustomArray(new double[]{5, 4, -8, 500, -11});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void replaceElementIncorrectIndexTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = replaceService.replaceElement(customArray, 500, -7);
        CustomArray expected = new CustomArray(new double[]{5, 4, -8, 15, -11});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void replaceElementNullTest() {
        assertThrows(CustomArrayException.class, () -> replaceService.replaceElement(null, 500, 3));
    }

    @Test
    public void replaceElementStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = replaceService.replaceElementStream(customArray, 500, 3);
        CustomArray expected = new CustomArray(new double[]{5, 4, -8, 500, -11});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void replaceElementStreamIncorrectIndexTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        CustomArray actual = replaceService.replaceElementStream(customArray, 500, -7);
        CustomArray expected = new CustomArray(new double[]{5, 4, -8, 15, -11});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void replaceElementStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> replaceService.replaceElementStream(null, 500, 3));
    }
}
