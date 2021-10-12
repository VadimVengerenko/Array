package com.epam.array.converter.impl;

import com.epam.array.converter.CustomConverter;
import com.epam.array.entity.CustomArray;
import com.epam.array.exception.CustomArrayException;
import com.epam.array.validator.CustomValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;

public class CustomConverterImpl implements CustomConverter {
    private static final String DELIMITER_REGEX = "\\s-\\s";
    static Logger logger = LogManager.getLogger();

    public CustomArray stringsToArray(ArrayList<String> strings) throws CustomArrayException {
        if (strings == null) {
            logger.error("couldn't convert (ArrayList<String>) null to CustomArray");
            throw new CustomArrayException("couldn't convert (ArrayList<String>) null to CustomArray");
        }
        String[] buffer;
        ArrayList<Double> doubles = new ArrayList<>();
        for (String string : strings) {
            if (CustomValidator.validateLine(string)) {
                buffer = string.split(DELIMITER_REGEX);
                for (String str : buffer) {
                    doubles.add(stringToDouble(str).get());
                }
            }
        }
        logger.info("ArrayList<String> was successfully converted to CustomArray");
        return new CustomArray(arrayListToArray(doubles));
    }

    public Optional<Double> stringToDouble(String str) throws CustomArrayException {
        if (str == null) {
            logger.error("couldn't convert (String) null to double");
            throw new CustomArrayException("couldn't convert (String) null to double");
        }
        Optional<Double> value = Optional.empty();
        double multiplier = 1;
        int afterPointCounter = 0;
        boolean beforePoint = true;
        char buffer;
        int i = 0;
        while (i < str.length()) {
            buffer = str.charAt(i);
            if (!value.isPresent() && buffer >= '0' && buffer <= '9') {
                value = Optional.of(0.0);
            }
            if (buffer == '+') {
                multiplier = 1;
            } else if (buffer == '-') {
                multiplier = -1;
            } else if (buffer == '.') {
                beforePoint = false;
            } else if (beforePoint && buffer >= '0' && buffer <= '9') {
                value = Optional.of(value.get() * 10.0 + buffer - '0');
            } else if (buffer >= '0' && buffer <= '9') {
                afterPointCounter++;
                value = Optional.of(value.get() + (buffer - '0') / Math.pow(10.0, afterPointCounter));
            } else {
                value = Optional.empty();
                break;
            }
            i++;
        }
        logger.info("String \"" + str + "\" was successfully converted to double");
        return value.isPresent() ? Optional.of(multiplier * value.get()) : value;
    }

    public double[] arrayListToArray(ArrayList<Double> doubles) throws CustomArrayException {
        if (doubles == null) {
            logger.error("couldn't convert (ArrayList<Double>) null to double[]");
            throw new CustomArrayException("couldn't convert (ArrayList<Double>) null to double[]");
        }
        double[] array = new double[doubles.size()];
        Double temp;
        for (int i = 0; i < doubles.size(); i++) {
            temp = doubles.get(i);
            if (temp == null) {
                logger.error("double initialization error");
                throw new CustomArrayException("double initialization error");
            }
            array[i] = temp;
        }
        logger.info("ArrayList<Double> was successfully converted to double[]");
        return array;
    }

    public double[] arrayListToArrayStream(ArrayList<Double> doubles) throws CustomArrayException {
        if (doubles == null) {
            logger.error("couldn't convert (ArrayList<Double>) null to double[]");
            throw new CustomArrayException("couldn't convert (ArrayList<Double>) null to double[]");
        }
        double[] array = new double[doubles.size()];
        IntStream
                .range(0, doubles.size())
                .filter(i -> doubles.get(i) != null)
                .forEach(i -> array[i] = doubles.get(i));
        logger.info("ArrayList<Double> was successfully converted to double[]");
        return array;
    }
}
