package test.epam.array.converter.impl;

import com.epam.array.converter.CustomConverter;
import com.epam.array.converter.impl.CustomConverterImpl;
import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CustomConverterImplTest {
    private final CustomConverter customConverter = new CustomConverterImpl();

    @Test
    public void stringsToArrayTest() throws CustomArrayException {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(
                "-4. - 3 - +2.7 - .5 - 1230.178354",
                "--5 - 15 - 13",
                "+31..1 - 10 - 20 - 30",
                "1a9 - 3 - +4 - 5"
        ));
        CustomArray actual = customConverter.stringsToArray(strings);
        CustomArray expected = new CustomArray(new double[]{-4, 3, 2.7, 0.5, 1230.178354});
        assertArrayEquals(expected.getArray(), actual.getArray(), 0.001);
    }

    @Test
    public void stringsToArrayNullTest() {
        assertThrows(CustomArrayException.class, () -> customConverter.stringsToArray(null));
    }

    @Test
    public void stringToDoubleTest() throws CustomArrayException {
        Optional<Double> actual = customConverter.stringToDouble("1234.5678");
        Optional<Double> expected = Optional.of(1234.5678);
        assertEquals(expected.get(), actual.get(), 0.001);
    }

    @Test
    public void stringToDoubleNullTest() {
        assertThrows(CustomArrayException.class, () -> customConverter.stringToDouble(null));
    }

    @Test
    public void arrayListToArrayTest() throws CustomArrayException {
        ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(1., 2., 3., 4.));
        double[] actual = customConverter.arrayListToArray(doubles);
        double[] expected = new double[]{1, 2, 3, 4};
        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void arrayListToArrayNullTest() {
        assertThrows(CustomArrayException.class, () -> customConverter.arrayListToArray(null));
    }

    @Test
    public void arrayListToArrayNullElementTest() {
        ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(
                1., null, 3., 4.));
        assertThrows(CustomArrayException.class, () -> customConverter.arrayListToArray(doubles));
    }

    @Test
    public void arrayListToArrayStreamTest() throws CustomArrayException {
        ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(1., 2., 3., 4.));
        double[] actual = customConverter.arrayListToArrayStream(doubles);
        double[] expected = new double[]{1, 2, 3, 4};
        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void arrayListToArrayStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> customConverter.arrayListToArrayStream(null));
    }
}
