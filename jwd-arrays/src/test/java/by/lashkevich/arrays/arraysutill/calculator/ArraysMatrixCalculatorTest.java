package by.lashkevich.arrays.arraysutill.calculator;

import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysMatrixCalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ArraysMatrixCalculatorTest {
    @DataProvider(name = "dataForMatrixMultiplying")
    public Object[][] createDataForMatrixMultiplying() {
        return new Object[][] {
                {Arrays.asList(new ArraysMatrix(new int[][]{{1, 2}, {3, 4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{7, 10}, {15, 22}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{0, 0}, {0, 0}}),
                        new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})),
                        new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{-1, -2}, {-3, -4}}),
                        new ArraysMatrix(new int[][]{{-1, -2}, {-3, -4}})),
                        new ArraysMatrix(new int[][]{{7, 10}, {15, 22}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{Integer.MAX_VALUE, 2}, {3, 4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{-2147483643, 6}, {15, 22}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{Integer.MIN_VALUE, -2}, {-3, -4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{2147483642, -8}, {-15, -22}})},
        };
    }

    @DataProvider(name = "dataForMatrixTranspose")
    public Object[][] createDataForMatrixTranspose() {
        return new Object[][] {
                {new ArraysMatrix(new int[][]{{1, 2}, {3, 4}}), new ArraysMatrix(new int[][]{{1, 3}, {2, 4}})},
                {new ArraysMatrix(new int[][]{{0, 0}, {0, 0}}), new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})},
                {new ArraysMatrix(new int[][]{{-1, -2}, {-3, -4}}), new ArraysMatrix(new int[][]{{-1, -3}, {-2, -4}})},
                {new ArraysMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}}),
                        new ArraysMatrix(new int[][]{{1, 4}, {2, 5}, {3, 6}})},
        };
    }

    @DataProvider(name = "dataForMatrixAddition")
    public Object[][] createDataForMatrixAddition() {
        return new Object[][] {
                {Arrays.asList(new ArraysMatrix(new int[][]{{1, 2}, {3, 4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{2, 4}, {6, 8}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{0, 0}, {0, 0}}),
                        new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})),
                        new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{-1, -2}, {-3, -4}}),
                        new ArraysMatrix(new int[][]{{-1, -2}, {-3, -4}})),
                        new ArraysMatrix(new int[][]{{-2, -4}, {-6, -8}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{Integer.MAX_VALUE, 2}, {3, 4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{-2147483648, 4}, {6, 8}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{Integer.MIN_VALUE, -2}, {-3, -4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{-2147483647, 0}, {0, 0}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{Integer.MAX_VALUE, -2}, {-3, -4}}),
                        new ArraysMatrix(new int[][]{{Integer.MAX_VALUE, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{-2, 0}, {0, 0}})},
        };
    }

    @DataProvider(name = "dataForMatrixSubtraction")
    public Object[][] createDataForMatrixSubtraction() {
        return new Object[][] {
                {Arrays.asList(new ArraysMatrix(new int[][]{{1, 2}, {3, 4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{0, 0}, {0, 0}}),
                        new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})),
                        new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{-1, -2}, {-3, -4}}),
                        new ArraysMatrix(new int[][]{{-1, -2}, {-3, -4}})),
                        new ArraysMatrix(new int[][]{{0, 0}, {0, 0}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{Integer.MAX_VALUE, 2}, {3, 4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{2147483646, 0}, {0, 0}})},
                {Arrays.asList(new ArraysMatrix(new int[][]{{Integer.MIN_VALUE, -2}, {-3, -4}}),
                        new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})),
                        new ArraysMatrix(new int[][]{{2147483647, -4}, {-6, -8}})},
        };
    }

    @Test (description = "matrix multiplication test", dataProvider = "dataForMatrixMultiplying")
    public void multiplyMatrixTest(List<ArraysMatrix> matrices,
                                   ArraysMatrix expectedResult) throws ArraysMatrixCalculatorException {
        Assert.assertEquals(ArraysMatrixCalculator.multiply(matrices.get(0), matrices.get(1)), expectedResult);
    }

    @Test (description = "matrix addition test", dataProvider = "dataForMatrixAddition")
    public void addMatrixTest(List<ArraysMatrix> matrices,
                              ArraysMatrix expectedResult) throws ArraysMatrixCalculatorException {
        Assert.assertEquals(ArraysMatrixCalculator.add(matrices.get(0), matrices.get(1)), expectedResult);
    }

    @Test (description = "matrix subtraction test", dataProvider = "dataForMatrixSubtraction")
    public void subtractMatrixTest(List<ArraysMatrix> matrices,
                                   ArraysMatrix expectedResult) throws ArraysMatrixCalculatorException {
        Assert.assertEquals(ArraysMatrixCalculator.subtract(matrices.get(0), matrices.get(1)), expectedResult);
    }

    @Test (description = "matrix transpose test", dataProvider = "dataForMatrixTranspose")
    public void transposeMatrixTest(ArraysMatrix matrix,
                                    ArraysMatrix expectedResult) throws ArraysMatrixCalculatorException {
        Assert.assertEquals((ArraysMatrixCalculator.transpose(matrix)), expectedResult);
    }
}