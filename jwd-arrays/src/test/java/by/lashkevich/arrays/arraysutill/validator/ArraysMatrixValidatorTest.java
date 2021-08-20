package by.lashkevich.arrays.arraysutill.validator;

import by.lashkevich.arrays.entity.ArraysMatrix;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysMatrixValidatorTest {
    @DataProvider(name = "dataForMultiplyMatrixValidator")
    public Object[][] createDataForMultiplyMatrixValidator() {
        return new Object[][]{
                {Arrays.asList(new ArraysMatrix(new int[][]{{1, 2}, {3, 4}}),
                        new ArraysMatrix(new int[][]{{5, 6}, {7, 8}})), true},
                {Arrays.asList(new ArraysMatrix(new int[][]{{6, 34}, {5, 1}}),
                        new ArraysMatrix(new int[][]{{2, 3, 3}, {7, 8, 4}})), false},
        };
    }

    @DataProvider(name = "dataForAddAndSubtractMatrixValidator")
    public Object[][] createDataForAddAndSubtractMatrixValidator() {
        return new Object[][]{
                {Arrays.asList(new ArraysMatrix(new int[][]{{4, 5}, {3, 1}}),
                        new ArraysMatrix(new int[][]{{5, 7}, {7, 6}})), true},
                {Arrays.asList(new ArraysMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}}),
                        new ArraysMatrix(new int[][]{{7, 8, 9}, {10, 11, 12}})), true},
                {Arrays.asList(new ArraysMatrix(new int[][]{{6, 34, 23}, {2, 55, 21}}),
                        new ArraysMatrix(new int[][]{{3, 14}, {7, 5,}})), false},
        };
    }

    @DataProvider(name = "dataForMatrixNullValidating")
    public Object[][] createDataForNullValidating() {
        return new Object[][]{
                {Arrays.asList(new ArraysMatrix(new int[][]{{2, 4}, {2, 1}}),
                        new ArraysMatrix(new int[][]{{2, 4}, {4, 4}})), true},
                {Arrays.asList(new ArraysMatrix(new int[][]{{4, 3}, {1, 6}}),
                        new ArraysMatrix(new int[][]{{5, 3, 2}, {10, 12, 0}})), true},
                {Arrays.asList(new ArraysMatrix(new int[][]{{6, 34, 23}, {2, 55, 21}}), null), false},
        };
    }


    @Test(description = "Checking of positive and negative matrices for multiplication validation",
            dataProvider = "dataForMultiplyMatrixValidator")
    public void validateMultiplyMatricesTest(List<ArraysMatrix> matrices, boolean expectedResult) {
        Assert.assertEquals(ArraysMatrixValidator
                .validateMultiplyMatrices(matrices.get(0), matrices.get(1)), expectedResult);
    }

    @Test(description = "Checking of positive and negative matrices for addition or subtraction validation",
            dataProvider = "dataForAddAndSubtractMatrixValidator")
    public void validateAddOrSubtractMatricesTest(List<ArraysMatrix> matrices, boolean expectedResult) {
        Assert.assertEquals(ArraysMatrixValidator
                .validateAddOrSubtractMatrices(matrices.get(0), matrices.get(1)), expectedResult);
    }

    @Test(description = "Positive and negative scenario of null checking",
            dataProvider = "dataForMatrixNullValidating")
    public void validateForNullTest(List<ArraysMatrix> matrices, boolean expectedResult) {
        Assert.assertEquals(ArraysMatrixValidator
                .validateForNull(matrices.get(0), matrices.get(1)), expectedResult);
    }
}