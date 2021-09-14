package by.lashkevich.multithreading.dao;

import by.lashkevich.multithreading.entity.Matrix;

import java.util.List;

/**
 * Interface for management matrix data
 * @author Roman Lashkevich
 */
public interface MatrixDao {
    Matrix findMatrix();
    int findElement(int verticalSize, int horizontalSize);
    void updateElement(int verticalSize, int horizontalSize, int element);
    List<Integer> getMatrixSizeRange();
}
