package test.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.service.ArrayCountService;
import com.epam.array.service.impl.ArrayCountServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayCountServiceImplTest {
    private final ArrayCountService countService = new ArrayCountServiceImpl();

    @Test
    public void countPositiveTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        Optional<Integer> actual = countService.countPositive(customArray);
        Optional<Integer> expected = Optional.of(3);
        assertEquals(expected, actual);
    }

    @Test
    public void countPositiveNullTest() {
        assertThrows(CustomArrayException.class, () -> countService.countPositive(null));
    }

    @Test
    public void countPositiveStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        long actual = countService.countPositiveStream(customArray);
        long expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void countPositiveStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> countService.countPositiveStream(null));
    }

    @Test
    public void countNegativeTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        Optional<Integer> actual = countService.countNegative(customArray);
        Optional<Integer> expected = Optional.of(2);
        assertEquals(expected, actual);
    }

    @Test
    public void countNegativeNullTest() {
        assertThrows(CustomArrayException.class, () -> countService.countNegative(null));
    }

    @Test
    public void countNegativeStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new double[]{5, 4, -8, 15, -11});
        long actual = countService.countNegativeStream(customArray);
        long expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void countNegativeStreamNullTest() {
        assertThrows(CustomArrayException.class, () -> countService.countNegativeStream(null));
    }
}
