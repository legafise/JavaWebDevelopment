package by.lashkevich.arrays.service.impl;

import by.lashkevich.arrays.arraysutill.sorter.ArraysArraySorter;
import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.exception.ArraysSorterException;
import by.lashkevich.arrays.service.ArrayService;


/**
 * @see by.lashkevich.arrays.service.ArrayService
 */
public class ArraysArrayService implements ArrayService {
    private static final String INVALID_ARRAY_MESSAGE = "Invalid array was received";

    @Override
    public ArraysArray<Number> bubbleSort(ArraysArray<Number> array) throws ArraysServiceException {
        try {
            if (validateForNull(array)) {
                return ArraysArraySorter.sortByBubbleSort(array);
            }

            throw new ArraysServiceException(INVALID_ARRAY_MESSAGE);
        } catch (ArraysSorterException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    @Override
    public ArraysArray<Number> cocktailSort(ArraysArray<Number> array) throws ArraysServiceException {
        try {
            if (validateForNull(array)) {
                return ArraysArraySorter.sortByCocktailSort(array);
            }

            throw new ArraysServiceException(INVALID_ARRAY_MESSAGE);
        } catch (ArraysSorterException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    @Override
    public ArraysArray<Number> selectionSort(ArraysArray<Number> array) throws ArraysServiceException {
        try {
            if (validateForNull(array)) {
                return ArraysArraySorter.sortBySelectionSort(array);
            }

            throw new ArraysServiceException(INVALID_ARRAY_MESSAGE);
        } catch (ArraysSorterException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    @Override
    public ArraysArray<Number> insertionSort(ArraysArray<Number> array) throws ArraysServiceException {
        try {
            if (validateForNull(array)) {
                return ArraysArraySorter.sortByInsertionSort(array);
            }

            throw new ArraysServiceException(INVALID_ARRAY_MESSAGE);
        } catch (ArraysSorterException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    @Override
    public ArraysArray<Number> shellSort(ArraysArray<Number> array) throws ArraysServiceException {
        try {
            if (validateForNull(array)) {
                return ArraysArraySorter.sortByShellSort(array);
            }

            throw new ArraysServiceException(INVALID_ARRAY_MESSAGE);
        } catch (ArraysSorterException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    private boolean validateForNull(ArraysArray<Number> array) {
        return array != null;
    }
}
