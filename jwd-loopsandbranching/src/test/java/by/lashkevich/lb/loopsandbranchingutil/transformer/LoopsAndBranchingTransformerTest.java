package by.lashkevich.lb.loopsandbranchingutil.transformer;

import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LoopsAndBranchingTransformerTest {
    @DataProvider(name = "positiveStringsToDoublesData")
    public Object[][] createPositiveStringsToDoublesData() {
        return new Object[][]{
                {Arrays.asList("12.3", "15.2"), Arrays.asList(12.3, 15.2)},
                {Arrays.asList(String.valueOf(Double.MAX_VALUE), "0"), Arrays.asList(Double.MAX_VALUE, 0.)},
                {Arrays.asList(String.valueOf(Double.MIN_VALUE), "0"), Arrays.asList(Double.MIN_VALUE, 0.)},
                {Arrays.asList("12.3", "15.2"), Arrays.asList(12.3, 15.2)},
                {Arrays.asList("-5.5", "-6.4"), Arrays.asList(-5.5, -6.4)},
                {Arrays.asList("0", "0"), Arrays.asList(0.0, 0.0)},
        };
    }

    @DataProvider(name = "positiveStringsToIntegersData")
    public Object[][] createPositiveStringsToIntegersData() {
        return new Object[][]{
                {Arrays.asList("10", "5"), Arrays.asList(10, 5)},
                {Arrays.asList("0", "0"), Arrays.asList(0, 0)},
                {Arrays.asList("-2", "-3"), Arrays.asList(-2, -3)},
                {Arrays.asList(String.valueOf(Integer.MAX_VALUE), "0"), Arrays.asList(Integer.MAX_VALUE, 0)},
                {Arrays.asList(String.valueOf(Integer.MIN_VALUE), "0"), Arrays.asList(Integer.MIN_VALUE, 0)},
        };
    }

    @DataProvider(name = "positiveStringsToLongsData")
    public Object[][] createPositiveStringsToLongsData() {
        return new Object[][]{
                {Arrays.asList("20", "30"), Arrays.asList((long) 20, (long) 30)},
                {Arrays.asList("0", "0"), Arrays.asList((long) 0, (long) 0)},
                {Arrays.asList(String.valueOf(Long.MAX_VALUE), "0"), Arrays.asList(Long.MAX_VALUE, (long) 0)},
                {Arrays.asList("-10", "-15"), Arrays.asList((long) -10, (long) -15)},
                {Arrays.asList("0", String.valueOf(Long.MIN_VALUE)), Arrays.asList((long) 0, Long.MIN_VALUE)},
        };
    }

    @DataProvider(name = "positiveStringsToCharacterData")
    public Object[][] createPositiveStringsToCharacterData() {
        return new Object[][]{
                {Arrays.asList("&"), '&'},
                {Arrays.asList("1"), '1'},
                {Arrays.asList("G"), 'G'},
                {Arrays.asList("g"), 'g'},
        };
    }


    @Test(description = "Unusual positive strings to doubles transforming scenario",
            dataProvider = "positiveStringsToDoublesData")
    public void transformStringsToDoublesTest(List<String> strings,
                                              List<Double> expectedDoubles) throws LoopsAndBranchingTransformerException {
        Assert.assertEquals(LoopsAndBranchingTransformer.transformStringsToDoubles(strings), expectedDoubles);
    }

    @Test(description = "Unusual positive strings to integers transforming scenario",
            dataProvider = "positiveStringsToIntegersData")
    public void transformStringsToIntegersTest(List<String> strings,
                                               List<Integer> expectedIntegers) throws LoopsAndBranchingTransformerException {
        Assert.assertEquals(LoopsAndBranchingTransformer.transformStringsToIntegers(strings), expectedIntegers);
    }

    @Test(description = "Unusual positive strings to longs transforming scenario",
            dataProvider = "positiveStringsToLongsData")
    public void transformStringsToLongTest(List<String> strings,
                                           List<Long> expectedLongs) throws LoopsAndBranchingTransformerException {
        Assert.assertEquals(LoopsAndBranchingTransformer.transformStringsToLong(strings), expectedLongs);
    }

    @Test(description = "Unusual positive string to char transforming scenario",
            dataProvider = "positiveStringsToCharacterData")
    public void transformStringsToCharacterTest(List<String> strings,
                                                char expectedChar) {
        Assert.assertEquals(LoopsAndBranchingTransformer.transformStringsToCharacter(strings), expectedChar);
    }
}