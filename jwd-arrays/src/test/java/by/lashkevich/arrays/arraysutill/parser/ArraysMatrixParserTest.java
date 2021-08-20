package by.lashkevich.arrays.arraysutill.parser;

import by.lashkevich.arrays.entity.ArraysMatrix;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ArraysMatrixParserTest {
    private ArraysMatrixParser matrixParser;

    @BeforeMethod
    public void setUp() {
        matrixParser = new ArraysMatrixParser();
    }

    @DataProvider(name = "dataForOneMatrixParser")
    public Object[][] createDataForMatrixAddition() {
        return new Object[][]{
                {Arrays.asList("2", "2", "1", "2", "3", "4"), new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})},
                {Arrays.asList("2", "2", "1", "2", "3", "4", "3"), new ArraysMatrix(new int[][]{{1, 2}, {3, 4}})},
                {Arrays.asList("2", "3", "1", "2", "3", "4", "5", "6"),
                        new ArraysMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}})},
        };
    }

    @DataProvider(name = "dataMatrixListParser")
    public Object[][] createDataForTwoMatrixParser() {
        return new Object[][]{
                {Arrays.asList("2", "2", "1", "2", "3", "4", "2", "2", "1", "2", "3", "4"),
                        Arrays.asList(new ArraysMatrix(new int[][]{{1, 2}, {3, 4}}),
                                new ArraysMatrix(new int[][]{{1, 2}, {3, 4}}))},
        };
    }

    @Test (description = "parse one matrix test", dataProvider = "dataForOneMatrixParser")
    public void parseOneMatrixTest(List<String> matrixData, ArraysMatrix expectedResult) {
        Assert.assertEquals(matrixParser.parseOneMatrix(matrixData), expectedResult);
    }

    @Test (description = "parse matrix list test", dataProvider = "dataMatrixListParser")
    public void parseMatrixListTest(List<String> matrixData, List<ArraysMatrix> expectedResult) {
        Assert.assertEquals(matrixParser.parseMatrixList(matrixData), expectedResult);
    }
}