package test.epam.array.reader.impl;

import com.epam.array.exception.CustomArrayException;
import com.epam.array.reader.impl.CustomFileReaderImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CustomFileReaderTestImpl {
    private final CustomFileReaderImpl fileReader = new CustomFileReaderImpl();

    @Test
    public void readFileTest() throws CustomArrayException {
        ArrayList<String> actual = fileReader.readFile("./input/input.txt");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(
                "1. - .2 - 3.5 - 4 - 5 - 6",
                "+7 - -8 - 9 - 1 - 2 - 3"));
        assertEquals(expected, actual);
    }

    @Test
    public void readFileWrongTest() {
        assertThrows(CustomArrayException.class, () -> fileReader.readFile(""));
    }
}
