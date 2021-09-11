package by.lashkevich.multithreading.service;

import by.lashkevich.multithreading.entity.Matrix;

public interface MatrixService {
    void setElement(int i, int j, int element) throws ServiceException;
    int getElement(int i, int j) throws ServiceException;
    Matrix findMatrix() throws ServiceException;
}
