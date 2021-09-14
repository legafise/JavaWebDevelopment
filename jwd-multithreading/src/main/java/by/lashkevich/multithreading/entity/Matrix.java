package by.lashkevich.multithreading.entity;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Class created to work with matrices
 * @author RomalLashkevich
 */
public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getElement(int verticalId, int horizontalId) {
        return matrix[verticalId][horizontalId];
    }

    public int getVerticalSize() {
        return matrix.length;
    }

    public int getHorizontalSize() {
        return matrix[0].length;
    }

    public void setElement(int i, int j, int value) {
        matrix[i][j] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return matrix1.getVerticalSize() == this.getVerticalSize()
                && matrix1.getHorizontalSize() == this.getHorizontalSize() && compareMatrices(matrix1);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Matrix : " + matrix.length + "x"
                + matrix[0].length + "\n");
        for (int[] row : matrix) {
            for (int value : row) {
                s.append(value).append(" ");
            }
            s.append("\n");
        }

        return s.toString();
    }

    private boolean compareMatrices(Matrix matrix) {
        for (int i = 0; i < matrix.getHorizontalSize(); i++) {
            for (int j = 0; j < matrix.getVerticalSize(); j++) {
                if (BigDecimal.valueOf(matrix.getElement(i, j))
                        .compareTo(BigDecimal.valueOf(this.getElement(i, j))) != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}