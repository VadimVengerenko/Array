package test.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.service.impl.ArrayFindServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayFindServiceImplTest {
    private final ArrayFindServiceImpl findService = new ArrayFindServiceImpl();

    @Test
    public void findAverageValTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        Optional<Double> actual = findService.findAverageVal(customArray);
        Optional<Double> expected = Optional.of(1.0);
        assertEquals(expected.get(), actual.get(), 0.001);
    }

    @Test
    public void findAverageValNullTest() {
        assertThrows(CustomArrayException.class, () -> findService.findAverageVal(null));
    }

    @Test
    public void findAverageValStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        OptionalDouble actual = findService.findAverageValStream(customArray);
        OptionalDouble expected = OptionalDouble.of(1);
        assertEquals(expected.getAsDouble(), actual.getAsDouble(), 0.001);
    }

    @Test
    public void findAverageValStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> findService.findAverageValStream(null));
    }

    @Test
    public void findMinTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        Optional<Double> actual = findService.findMin(customArray);
        Optional<Double> expected = Optional.of(-11.0);
        assertEquals(expected.get(), actual.get(), 0.001);
    }

    @Test
    public void findMinNullTest() {
        assertThrows(CustomArrayException.class, () -> findService.findMin(null));
    }

    @Test
    public void findMinStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        OptionalDouble actual = findService.findMinStream(customArray);
        OptionalDouble expected = OptionalDouble.of(-11);
        assertEquals(expected.getAsDouble(), actual.getAsDouble(), 0.001);
    }

    @Test
    public void findMinStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> findService.findMinStream(null));
    }

    @Test
    public void findMaxTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        Optional<Double> actual = findService.findMax(customArray);
        Optional<Double> expected = Optional.of(15.0);
        assertEquals(expected.get(), actual.get(), 0.001);
    }

    @Test
    public void findMaxNullTest() {
        assertThrows(CustomArrayException.class, () -> findService.findMax(null));
    }

    @Test
    public void findMaxStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        OptionalDouble actual = findService.findMaxStream(customArray);
        OptionalDouble expected = OptionalDouble.of(15);
        assertEquals(expected.getAsDouble(), actual.getAsDouble(), 0.001);
    }

    @Test
    public void findMaxStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> findService.findMaxStream(null));
    }

    @Test
    public void findSumTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        Optional<Double> actual = findService.findSum(customArray);
        Optional<Double> expected = Optional.of(5.0);
        assertEquals(expected.get(), actual.get(), 0.001);
    }

    @Test
    public void findSumNullTest() {
        assertThrows(CustomArrayException.class, () -> findService.findSum(null));
    }

    @Test
    public void findSumStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        double actual = findService.findSumStream(customArray);
        double expected = 5;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void findSumStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> findService.findSumStream(null));
    }
}
