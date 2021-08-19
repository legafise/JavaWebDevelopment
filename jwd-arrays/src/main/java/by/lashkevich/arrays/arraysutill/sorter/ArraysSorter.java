package by.lashkevich.arrays.arraysutill.sorter;

import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysArrayException;
import by.lashkevich.arrays.exception.ArraysSorterException;

import java.math.BigDecimal;

public final class ArraysSorter {

    private ArraysSorter() {
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
            int leftBorder = 0;

            for (int i = leftBorder; i < array.getLength(); i++) {
                int minInd = i;
                for (int j = i; j < array.getLength(); j++) {
                    if (numberComparator(array.getElement(minInd), array.getElement(j))) {
                        minInd = j;
                    }
                }

                swapElements(array, i, minInd);
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

                while ((j > -1) && numberComparator(array.getElement(j), key)){
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
