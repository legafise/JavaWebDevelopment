package by.lashkevich.arrays.arraysutill.parser.impl;

import by.lashkevich.arrays.arraysutill.parser.ArrayParser;
import by.lashkevich.arrays.entity.ArraysArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysFloatArrayParserTest {
    private ArrayParser arrayParser;

    @BeforeMethod
    public void setUp() {
        arrayParser = new ArraysFloatArrayParser();
    }

    @DataProvider(name = "dataForFloatArrayParsing")
    public Object[][] createDataForFloatArrayParsing() {
        return new Object[][] {
                {Arrays.asList("1.3", "2.2"), new ArraysArray<>(new Float[]{1.3F, 2.2F})},
                {Arrays.asList("1.1"), new ArraysArray<>(new Float[]{1.1F})},
                {Arrays.asList("5.3", "5.1"), new ArraysArray<>(new Float[]{5.3F, 5.1F})},
                {Arrays.asList("-5.0", "-1.0"), new ArraysArray<>(new Float[]{-5.0F, -1.0F})},
        };
    }

    @Test(description = "Positive scenario of parsing float array from string list",
            dataProvider = "dataForFloatArrayParsing")
    public void parseArrayTest(List<String> data, ArraysArray<Float> expectedResult) {
        Assert.assertEquals(arrayParser.parseArray(data), expectedResult);
    }
}