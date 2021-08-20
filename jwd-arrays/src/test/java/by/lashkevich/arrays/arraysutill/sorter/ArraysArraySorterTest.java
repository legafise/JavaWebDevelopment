package by.lashkevich.arrays.arraysutill.sorter;

import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysSorterException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ArraysArraySorterTest {
    @DataProvider(name = "dataForSorting")
    public Object[][] createDataForMatrixAddition() {
        return new Object[][]{
                {new ArraysArray(new Integer[]{5, 3, 2, 4, 2, 8, 7, 1, 9}),
                        new ArraysArray(new Integer[]{1, 2, 2, 3, 4, 5, 7, 8, 9})},
                {new ArraysArray(new Long[]{9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L}),
                        new ArraysArray(new Long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L})},
                {new ArraysArray(new Double[]{2.5, 1.5}),
                        new ArraysArray(new Double[]{1.5, 2.5})},
                {new ArraysArray(new Byte[]{1}),
                        new ArraysArray(new Byte[]{1})},
                {new ArraysArray(new Float[]{Float.MAX_VALUE, Float.MIN_VALUE}),
                        new ArraysArray(new Float[]{Float.MIN_VALUE, Float.MAX_VALUE})},
                {new ArraysArray(new Integer[]{}),
                        new ArraysArray(new Integer[]{})},
                {new ArraysArray(new Byte[]{5, 3, Byte.MAX_VALUE, 7, 1, 2, Byte.MIN_VALUE, 10}),
                        new ArraysArray(new Byte[]{Byte.MIN_VALUE, 1, 2, 3, 5, 7, 10, Byte.MAX_VALUE})},
                {new ArraysArray(new Double[]{-4.1, -15.3, -2.1, -100.32, 11.5, -63.4, 5.0}),
                        new ArraysArray(new Double[]{-100.32, -63.4, -15.3, -4.1, -2.1, 5.0, 11.5})},
                {new ArraysArray(new Integer[]{1, 1, 1, 1, 1}),
                        new ArraysArray(new Integer[]{1, 1, 1, 1, 1})},
                {new ArraysArray(new Byte[]{2, 2, 3, 3, 1, 1}),
                        new ArraysArray(new Byte[]{1, 1, 2, 2, 3, 3})},
        };
    }

    @Test (description = "Singular scenario for bubble sort", dataProvider = "dataForSorting")
    public void sortByBubbleSortWithSingularScenarioTest(ArraysArray<Number> array,
                                                         ArraysArray<Number> expectedResult) throws ArraysSorterException {
        Assert.assertEquals(ArraysArraySorter.sortByBubbleSort(array), expectedResult);
    }

    @Test (description = "Singular scenario for cocktail sort", dataProvider = "dataForSorting")
    public void sortByCocktailSortWithSingularScenarioTest(ArraysArray<Number> array,
                                                           ArraysArray<Number> expectedResult) throws ArraysSorterException {
        Assert.assertEquals(ArraysArraySorter.sortByCocktailSort(array), expectedResult);
    }

    @Test (description = "Singular scenario for selection sort", dataProvider = "dataForSorting")
    public void sortBySelectionSortWithSingularScenarioTest(ArraysArray<Number> array,
                                                            ArraysArray<Number> expectedResult) throws ArraysSorterException {
        Assert.assertEquals(ArraysArraySorter.sortBySelectionSort(array), expectedResult);
    }

    @Test (description = "Singular scenario for insertion sort", dataProvider = "dataForSorting")
    public void sortByInsertionSortWithSingularScenarioTest(ArraysArray<Number> array,
                                                            ArraysArray<Number> expectedResult) throws ArraysSorterException {
        Assert.assertEquals(ArraysArraySorter.sortByInsertionSort(array), expectedResult);
    }

    @Test (description = "Singular scenario for Shell sort", dataProvider = "dataForSorting")
    public void sortByShellSortWithSingularScenarioTest(ArraysArray<Number> array,
                                                        ArraysArray<Number> expectedResult) throws ArraysSorterException {
        Assert.assertEquals(ArraysArraySorter.sortByShellSort(array), expectedResult);
    }
}