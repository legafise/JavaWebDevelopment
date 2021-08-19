package by.lashkevich.arrays.service;

import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysServiceException;

/**
 * Service that executes the logic for sort arrays
 * @author Roman Lashkevich
 */
public interface ArrayService {
    ArraysArray<Number> bubbleSort(ArraysArray<Number> array) throws ArraysServiceException;

    ArraysArray<Number> cocktailSort(ArraysArray<Number> array) throws ArraysServiceException;

    ArraysArray<Number> selectionSort(ArraysArray<Number> array) throws ArraysServiceException;

    ArraysArray<Number> insertionSort(ArraysArray<Number> array) throws ArraysServiceException;

    ArraysArray<Number> shellSort(ArraysArray<Number> array) throws ArraysServiceException;
}
