package com.epam.array.entity;

import com.epam.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArray {
    private double[] array;
    static Logger logger = LogManager.getLogger();

    public CustomArray(double[] array) throws CustomArrayException {
        if (array == null || array.length < 0) {
            logger.error("double[] initialization error");
            throw new CustomArrayException("double[] initialization error");
        }
        this.array = getArrayClone(array);
    }

    public double[] getArray() {
        return getArrayClone(array);
    }

    public void setArray(double[] newArray) throws CustomArrayException {
        if (newArray == null || newArray.length < 0) {
            logger.error("double[] reinitialization error");
            throw new CustomArrayException("double[] reinitialization error");
        }
        this.array = getArrayClone(newArray);
    }

    public boolean equals(CustomArray customArray) {
        if (customArray == null) {
            return false;
        } else if (this == customArray) {
            return true;
        }
        double[] array = customArray.getArray();
        if (array.length != this.array.length) {
            return false;
        }
        int i = 0;
        while (array[i] == this.array[i]) {
            if (i == array.length - 1) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.array);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    private double[] getArrayClone(double[] array) {
        double[] arrayClone = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayClone[i] = array[i];
        }
        logger.info("array was successfully cloned");
        return arrayClone;
    }
}
