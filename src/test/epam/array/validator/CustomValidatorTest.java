package test.epam.array.validator;

import com.epam.array.validator.CustomValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomValidatorTest {
    @Test
    public void validateLinePositiveTest() {
        boolean actual = CustomValidator.validateLine("+5. - -.1 - +100.5");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void validateLineNegativeTest() {
        boolean actual = CustomValidator.validateLine("+5. - -..1 - +-100.5 - a");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void validateLineNullTest() {
        boolean actual = CustomValidator.validateLine(null);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
