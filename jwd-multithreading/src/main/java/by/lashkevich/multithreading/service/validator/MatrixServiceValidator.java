package by.lashkevich.multithreading.service.validator;

import by.lashkevich.multithreading.entity.Matrix;

/**
 * Class that validates matrices
 * @author RomalLashkevich
 */
public class MatrixServiceValidator {
    public boolean isValidRange(Matrix matrix, int i, int j) {
        return i >= 0 && i < matrix.getVerticalSize() && j >= 0 && j < matrix.getHorizontalSize();
    }

    public boolean isValidSize(Matrix matrix, int minSize, int maxSize) {
        return matrix.getHorizontalSize() >= minSize && matrix.getHorizontalSize() <= maxSize;
    }
}
