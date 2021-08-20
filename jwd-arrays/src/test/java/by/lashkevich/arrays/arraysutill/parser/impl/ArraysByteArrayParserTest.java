package by.lashkevich.arrays.arraysutill.parser.impl;

import by.lashkevich.arrays.arraysutill.parser.ArrayParser;
import by.lashkevich.arrays.entity.ArraysArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysByteArrayParserTest {
    private ArrayParser arrayParser;

    @BeforeMethod
    public void setUp() {
        arrayParser = new ArraysByteArrayParser();
    }

    @DataProvider(name = "dataForByteArrayParsing")
    public Object[][] createDataForByteArrayParsing() {
        return new Object[][] {
                {Arrays.asList("1", "2"), new ArraysArray<>(new Byte[]{1, 2})},
                {Arrays.asList("1"), new ArraysArray<>(new Byte[]{1})},
                {Arrays.asList("5", "5"), new ArraysArray<>(new Byte[]{5, 5})},
                {Arrays.asList("-1", "-2"), new ArraysArray<>(new Byte[]{-1, -2})},
        };
    }

    @Test (description = "Positive scenario of parsing byte array from string list",
            dataProvider = "dataForByteArrayParsing")
    public void parseArrayTest(List<String> data, ArraysArray<Byte> expectedResult) {
        Assert.assertEquals(arrayParser.parseArray(data), expectedResult);
    }
}