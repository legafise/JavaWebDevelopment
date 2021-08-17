package by.lashkevich.arrays.service;

import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysServiceException;

public interface ArrayService {
    <T extends Number> ArraysArray<T> bubbleSort(ArraysArray<T> array) throws ArraysServiceException;

    <T extends Number> ArraysArray<T> cocktailSort(ArraysArray array) throws ArraysServiceException;
}
