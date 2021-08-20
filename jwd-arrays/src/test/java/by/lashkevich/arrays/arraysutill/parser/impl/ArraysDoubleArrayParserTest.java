package by.lashkevich.arrays.arraysutill.parser.impl;

import by.lashkevich.arrays.arraysutill.parser.ArrayParser;
import by.lashkevich.arrays.entity.ArraysArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysDoubleArrayParserTest {
    private ArrayParser arrayParser;

    @BeforeMethod
    public void setUp() {
        arrayParser = new ArraysDoubleArrayParser();
    }

    @DataProvider(name = "dataForDoubleArrayParsing")
    public Object[][] createDataForDoubleArrayParsing() {
        return new Object[][] {
                {Arrays.asList("1.3", "2.2"), new ArraysArray<>(new Double[]{1.3, 2.2})},
                {Arrays.asList("1.1"), new ArraysArray<>(new Double[]{1.1})},
                {Arrays.asList("5.3", "5.1"), new ArraysArray<>(new Double[]{5.3, 5.1})},
                {Arrays.asList("-5.0", "-1.0"), new ArraysArray<>(new Double[]{-5.0, -1.0})},
        };
    }

    @Test(description = "Positive scenario of parsing double array from string list",
            dataProvider = "dataForDoubleArrayParsing")
    public void parseArrayTest(List<String> data, ArraysArray<Double> expectedResult) {
        Assert.assertEquals(arrayParser.parseArray(data), expectedResult);
    }
}