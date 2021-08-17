package by.lashkevich.arrays.arraysutill.sorter;

import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysArrayException;
import by.lashkevich.arrays.exception.ArraysSorterException;

import java.math.BigDecimal;

public final class ArraysSorter {

    private ArraysSorter() {
    }

    public static <T extends Number> ArraysArray<T> sortByBubbleSort(ArraysArray<T> array) throws ArraysSorterException {
        try {
            for (int i = array.getLenght() - 1; i >= 1; i--) {
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

    public static <T extends Number> ArraysArray<T> sortByCocktailSort(ArraysArray<T> array) throws ArraysSorterException {
        try {
            int leftBorder = 0;
            int rightBorder = array.getLenght() - 1;

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

    private static <T extends Number> void swapElements(ArraysArray<T> array, int firstElementIndex,
                                                        int secondElementIndex) throws ArraysArrayException {
        T temp = array.getElement(firstElementIndex);
        array.setElement(firstElementIndex, array.getElement(secondElementIndex));
        array.setElement(secondElementIndex, temp);
    }

    private static boolean numberComparator(Number firstNumber, Number secondNumber) {
        return BigDecimal.valueOf(firstNumber.doubleValue())
                .compareTo(BigDecimal.valueOf(secondNumber.doubleValue())) > 0;
    }
}
