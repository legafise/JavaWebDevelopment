package by.lashkevich.arrays.arraysutill.validator;

import by.lashkevich.arrays.entity.ArraysMatrix;

import java.util.Arrays;
import java.util.Objects;

public final class ArraysMatrixValidator {
    private ArraysMatrixValidator() {
    }

    public static boolean validateMultiplyMatrices(ArraysMatrix firstMatrix, ArraysMatrix secondMatrix) {
        return firstMatrix.getHorizontalSize() == secondMatrix.getVerticalSize()
                && secondMatrix.getHorizontalSize() == firstMatrix.getVerticalSize();
    }

    public static boolean validateAddOrSubtractMatrices(ArraysMatrix firstMatrix, ArraysMatrix secondMatrix) {
        return firstMatrix.getHorizontalSize() == secondMatrix.getHorizontalSize()
                && secondMatrix.getVerticalSize() == firstMatrix.getVerticalSize();
    }

    public static boolean validateForNull(ArraysMatrix... matrices) {
        return matrices != null && Arrays.stream(matrices)
                .filter(Objects::isNull).count() < 1;
    }
}
