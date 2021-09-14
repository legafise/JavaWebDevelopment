package by.lashkevich.multithreading.service;

import by.lashkevich.multithreading.entity.Matrix;

/**
 * Interface that performs actions on matrices
 * @author Roman Lashkevich
 */
public interface MatrixService {
    void setElement(int i, int j, int element) throws ServiceException;
    int findElement(int i, int j) throws ServiceException;
    Matrix findMatrix() throws ServiceException;
    void fillMainDiagonalWithZeros();
}
