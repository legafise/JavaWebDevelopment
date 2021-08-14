package by.lashkevich.arrays.entity;

import by.lashkevich.arrays.exception.ArraysMatrixException;

public class ArraysMatrix {
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
}
