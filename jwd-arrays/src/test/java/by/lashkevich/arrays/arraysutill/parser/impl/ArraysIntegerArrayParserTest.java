package by.lashkevich.arrays.arraysutill.parser.impl;

import by.lashkevich.arrays.arraysutill.parser.ArrayParser;
import by.lashkevich.arrays.entity.ArraysArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysIntegerArrayParserTest {
    private ArrayParser arrayParser;

    @BeforeMethod
    public void setUp() {
        arrayParser = new ArraysIntegerArrayParser();
    }

    @DataProvider(name = "dataForIntegerArrayParsing")
    public Object[][] createDataForIntegerArrayParsing() {
        return new Object[][] {
                {Arrays.asList("1", "2"), new ArraysArray<>(new Integer[]{1, 2})},
                {Arrays.asList("1"), new ArraysArray<>(new Integer[]{1})},
                {Arrays.asList("5", "5"), new ArraysArray<>(new Integer[]{5, 5})},
                {Arrays.asList("-1", "-2"), new ArraysArray<>(new Integer[]{-1, -2})},
        };
    }

    @Test(description = "Positive scenario of parsing integer array from string list",
            dataProvider = "dataForIntegerArrayParsing")
    public void parseArrayTest(List<String> data, ArraysArray<Integer> expectedResult) {
        Assert.assertEquals(arrayParser.parseArray(data), expectedResult);
    }
}