package by.lashkevich.arrays.arraysutill.calculator;

import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysMatrixCalculatorException;
import by.lashkevich.arrays.exception.ArraysMatrixException;

/**
 * Class for performing various operations with matrices
 * @author Roman Lashkevich
 * @see by.lashkevich.arrays.entity.ArraysMatrix
 */
public final class ArraysMatrixCalculator {
    private ArraysMatrixCalculator() {
    }

    public static ArraysMatrix multiply(ArraysMatrix firstMatrix,
                                        ArraysMatrix secondMatrix) throws ArraysMatrixCalculatorException {
        int verticalSize = firstMatrix.getVerticalSize();
        int horizontalSize = secondMatrix.getHorizontalSize();
        int controlSize = firstMatrix.getHorizontalSize();

        try {
            ArraysMatrix result = new ArraysMatrix(verticalSize, horizontalSize);
            for (int i = 0; i < verticalSize; i++) {
                for (int j = 0; j < horizontalSize; j++) {
                    int value = 0;
                    for (int k = 0; k < controlSize; k++) {
                        value += firstMatrix.getElement(i, k) * secondMatrix.getElement(k, j);
                    }

                    result.setElement(i, j, value);
                }
            }

            return result;
        } catch (ArraysMatrixException e) {
            throw new ArraysMatrixCalculatorException(e);
        }
    }

    public static ArraysMatrix add(ArraysMatrix firstMatrix,
                                   ArraysMatrix secondMatrix) throws ArraysMatrixCalculatorException {
        int verticalSize = firstMatrix.getVerticalSize();
        int horizontalSize = secondMatrix.getHorizontalSize();

        try {
            ArraysMatrix result = new ArraysMatrix(verticalSize, horizontalSize);
            for (int i = 0; i < result.getVerticalSize(); i++) {
                for (int j = 0; j < result.getHorizontalSize(); j++) {
                    result.setElement(i, j, firstMatrix.getElement(i, j) + secondMatrix.getElement(i, j));
                }
            }

            return result;
        } catch (ArraysMatrixException e) {
            throw new ArraysMatrixCalculatorException(e);
        }
    }

    public static ArraysMatrix subtract(ArraysMatrix firstMatrix,
                                        ArraysMatrix secondMatrix) throws ArraysMatrixCalculatorException {
        int verticalSize = firstMatrix.getVerticalSize();
        int horizontalSize = secondMatrix.getHorizontalSize();

        try {
            ArraysMatrix result = new ArraysMatrix(verticalSize, horizontalSize);
            for (int i = 0; i < result.getVerticalSize(); i++) {
                for (int j = 0; j < result.getHorizontalSize(); j++) {
                    result.setElement(i, j, firstMatrix.getElement(i, j) - secondMatrix.getElement(i, j));
                }
            }

            return result;
        } catch (ArraysMatrixException e) {
            throw new ArraysMatrixCalculatorException(e);
        }
    }

    public static ArraysMatrix transpose(ArraysMatrix transposeMatrix) throws ArraysMatrixCalculatorException {
        int horizontalSize = transposeMatrix.getHorizontalSize();
        int verticalSize = transposeMatrix.getVerticalSize();

        try {
            ArraysMatrix result = new ArraysMatrix(horizontalSize, verticalSize);
            for (int i = 0; i < verticalSize; i++) {
                for (int j = 0; j < horizontalSize; j++) {
                    result.setElement(j, i, transposeMatrix.getElement(i, j));
                }
            }

            return result;
        } catch (ArraysMatrixException e) {
            throw new ArraysMatrixCalculatorException(e);
        }
    }
}
