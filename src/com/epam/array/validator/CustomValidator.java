package com.epam.array.validator;

public class CustomValidator {
    private static final String DOUBLE_REGEX = "[+-]?(\\d+\\.\\d*|\\d*\\.\\d+|\\d+)";
    private static final String DELIMITER_REGEX = "\\s-\\s";
    private static final String VALID_DOUBLE_ARRAY_STRING_REGEX = "^" + DOUBLE_REGEX + "(" + DELIMITER_REGEX + DOUBLE_REGEX + ")*" + "$";

    public static boolean validateLine(String arrayString) {
        return arrayString != null && arrayString.matches(VALID_DOUBLE_ARRAY_STRING_REGEX);
    }
}
