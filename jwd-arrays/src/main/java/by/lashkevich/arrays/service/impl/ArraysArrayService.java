package by.lashkevich.arrays.service.impl;

import by.lashkevich.arrays.arraysutill.sorter.ArraysSorter;
import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.exception.ArraysSorterException;
import by.lashkevich.arrays.service.ArrayService;

public class ArraysArrayService implements ArrayService {
    private static final String INVALID_ARRAY_MESSAGE = "Invalid array was received";

    @Override
    public <T extends Number> ArraysArray<T> bubbleSort(ArraysArray<T> array) throws ArraysServiceException {
        try {
            if (validateForNull(array)) {
                return ArraysSorter.sortByBubbleSort(array);
            }

            throw new ArraysServiceException(INVALID_ARRAY_MESSAGE);
        } catch (ArraysSorterException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    @Override
    public <T extends Number> ArraysArray<T> cocktailSort(ArraysArray array) throws ArraysServiceException {
        try {
            if (validateForNull(array)) {
                return ArraysSorter.sortByCocktailSort(array);
            }

            throw new ArraysServiceException(INVALID_ARRAY_MESSAGE);
        } catch (ArraysSorterException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    private boolean validateForNull(ArraysArray array) {
        return array != null;
    }
}
