package by.lashkevich.arrays.service;

import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysServiceException;

public interface MatrixService {
    ArraysMatrix multiplyMatrices(ArraysMatrix firstMatrix, ArraysMatrix secondMatrix) throws ArraysServiceException;
    ArraysMatrix addMatrices(ArraysMatrix firstMatrix, ArraysMatrix secondMatrix) throws ArraysServiceException;
    ArraysMatrix subtractMatrices(ArraysMatrix firstMatrix, ArraysMatrix secondMatrix) throws ArraysServiceException;
    ArraysMatrix transposeMatrix(ArraysMatrix matrix) throws ArraysServiceException;
}
