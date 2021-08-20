package by.lashkevich.arrays.arraysutill.parser.impl;

import by.lashkevich.arrays.arraysutill.parser.ArrayParser;
import by.lashkevich.arrays.entity.ArraysArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysLongArrayParserTest {
    private ArrayParser arrayParser;

    @BeforeMethod
    public void setUp() {
        arrayParser = new ArraysLongArrayParser();
    }

    @DataProvider(name = "dataForLongArrayParsing")
    public Object[][] createDataForIntegerArrayParsing() {
        return new Object[][] {
                {Arrays.asList("1", "2"), new ArraysArray<>(new Long[]{1L, 2L})},
                {Arrays.asList("1"), new ArraysArray<>(new Long[]{1L})},
                {Arrays.asList("5", "5"), new ArraysArray<>(new Long[]{5L, 5L})},
                {Arrays.asList("-1", "-2"), new ArraysArray<>(new Long[]{-1L, -2L})},
        };
    }

    @Test(description = "Positive scenario of parsing long array from string list",
            dataProvider = "dataForLongArrayParsing")
    public void parseArrayTest(List<String> data, ArraysArray<Long> expectedResult) {
        Assert.assertEquals(arrayParser.parseArray(data), expectedResult);
    }
}