package by.lashkevich.arrays.entity;

import by.lashkevich.arrays.exception.ArraysMatrixException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Class created to work with matrices
 *
 * @author RomalLashkevich
 */
public class ArraysMatrix {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String INVALID_RANGE_MESSAGE = "You are out of range of the matrix";
    private static final String INVALID_MATRIX_SIZE_MESSAGE = "Invalid matrix size entered";
    private static final String BLANK = " ";
    private static final String NEW_LINE_BREAK = "\n";
    private static final String X_SIGN = "x";
    private static final String MATRIX_SIZE_EQUAL_MESSAGE = "Matrix : ";
    private int[][] matrix;

    public ArraysMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public ArraysMatrix(int verticalSize, int horizontalSize) throws ArraysMatrixException {
        if (verticalSize < 1 || horizontalSize < 1) {
            throw new ArraysMatrixException(INVALID_MATRIX_SIZE_MESSAGE);
        }

        matrix = new int[verticalSize][horizontalSize];
    }

    public int getElement(int verticalId, int horizontalId) throws ArraysMatrixException {
        if (checkRange(verticalId, horizontalId)) {
            return matrix[verticalId][horizontalId];
        } else {
            throw new ArraysMatrixException(INVALID_RANGE_MESSAGE);
        }
    }

    public int getVerticalSize() {
        return matrix.length;
    }

    public int getHorizontalSize() {
        return matrix[0].length;
    }

    public void setElement(int i, int j, int value) throws ArraysMatrixException {
        if (checkRange(i, j)) {
            matrix[i][j] = value;
        } else {
            throw new ArraysMatrixException(INVALID_RANGE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArraysMatrix matrix1 = (ArraysMatrix) o;
        return matrix1.getVerticalSize() == this.getVerticalSize()
                && matrix1.getHorizontalSize() == this.getHorizontalSize() && compareMatrices(matrix1);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(MATRIX_SIZE_EQUAL_MESSAGE + matrix.length + X_SIGN
                + matrix[0].length + NEW_LINE_BREAK);
        for (int[] row : matrix) {
            for (int value : row) {
                s.append(value).append(BLANK);
            }
            s.append(NEW_LINE_BREAK);
        }

        return s.toString();
    }

    private boolean checkRange(int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }

    private boolean compareMatrices(ArraysMatrix matrix) {
        try {
            for (int i = 0; i < matrix.getHorizontalSize(); i++) {
                for (int j = 0; j < matrix.getVerticalSize(); j++) {
                    if (BigDecimal.valueOf(matrix.getElement(i, j))
                            .compareTo(BigDecimal.valueOf(this.getElement(i, j))) != 0) {
                        return false;
                    }
                }
            }
        } catch (ArraysMatrixException e) {
           LOGGER.log(Level.ERROR, e.getMessage());
        }

        return true;
    }
}
