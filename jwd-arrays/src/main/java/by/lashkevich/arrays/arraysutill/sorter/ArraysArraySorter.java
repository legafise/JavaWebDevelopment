package by.lashkevich.arrays.arraysutill.sorter;

import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysArrayException;
import by.lashkevich.arrays.exception.ArraysSorterException;

import java.math.BigDecimal;

/**
 * A class for applying different sorts to an array
 * @author Roman Lashkevich
 * @see by.lashkevich.arrays.entity.ArraysArray
 */
public final class ArraysArraySorter {

    private ArraysArraySorter() {
    }

    public static ArraysArray<Number> sortByBubbleSort(ArraysArray<Number> array) throws ArraysSorterException {
        try {
            for (int i = array.getLength() - 1; i >= 1; i--) {
                for (int j = 0; j < i; j++)
                    if (numberComparator(array.getElement(j), array.getElement(j + 1))) {
                        swapElements(array, j, j + 1);
                    }
            }

            return array;
        } catch (ArraysArrayException e) {
            throw new ArraysSorterException(e.getMessage());
        }
    }

    public static ArraysArray<Number> sortByCocktailSort(ArraysArray<Number> array) throws ArraysSorterException {
        try {
            int leftBorder = 0;
            int rightBorder = array.getLength() - 1;

            do {
                for (int i = leftBorder; i < rightBorder; i++) {
                    if (numberComparator(array.getElement(i), array.getElement(i + 1))) {
                        swapElements(array, i, i + 1);
                    }
                }
                rightBorder--;

                for (int i = rightBorder; i > leftBorder; i--) {
                    if (numberComparator(array.getElement(i - 1), array.getElement(i))) {
                        swapElements(array, i, i - 1);
                    }
                }

                leftBorder++;
            } while (leftBorder <= rightBorder);

            return array;
        } catch (ArraysArrayException e) {
            throw new ArraysSorterException(e.getMessage());
        }
    }

    public static ArraysArray<Number> sortBySelectionSort(ArraysArray<Number> array) throws ArraysSorterException {
        try {
            for (int i = 0; i < array.getLength(); i++) {
                int minElementId = i;
                for (int j = i; j < array.getLength(); j++) {
                    if (numberComparator(array.getElement(minElementId), array.getElement(j))) {
                        minElementId = j;
                    }
                }

                swapElements(array, i, minElementId);
            }

            return array;
        } catch (ArraysArrayException e) {
            throw new ArraysSorterException(e.getMessage());
        }
    }

    public static ArraysArray<Number> sortByInsertionSort(ArraysArray<Number> array) throws ArraysSorterException {
        try {
            for (int i = 1; i < array.getLength(); i++) {
                Number key = array.getElement(i);
                int j = i - 1;

                while ((j > -1) && numberComparator(array.getElement(j), key)) {
                    array.setElement(j + 1, array.getElement(j));
                    j--;
                }

                array.setElement(j + 1, key);
            }

            return array;
        } catch (ArraysArrayException e) {
            throw new ArraysSorterException(e.getMessage());
        }
    }

    public static ArraysArray<Number> sortByShellSort(ArraysArray<Number> array) throws ArraysSorterException {
        try {
            int h = 1;
            while (h * 3 < array.getLength()) {
                h = h * 3 + 1;
            }

            while (h >= 1) {
                for (int i = h; i < array.getLength(); i++) {
                    for (int j = i; j >= h; j = j - h) {
                        if (numberComparator(array.getElement(j - h), array.getElement(j)))
                            swapElements(array, j, j - h);
                    }
                }

                h = h / 3;
            }

            return array;
        } catch (ArraysArrayException e) {
            throw new ArraysSorterException(e.getMessage());
        }
    }

    private static void swapElements(ArraysArray<Number> array, int firstElementIndex,
                                     int secondElementIndex) throws ArraysArrayException {
        Number temp = array.getElement(firstElementIndex);
        array.setElement(firstElementIndex, array.getElement(secondElementIndex));
        array.setElement(secondElementIndex, temp);
    }

    private static boolean numberComparator(Number firstNumber, Number secondNumber) {
        return BigDecimal.valueOf(firstNumber.doubleValue())
                .compareTo(BigDecimal.valueOf(secondNumber.doubleValue())) > 0;
    }
}
