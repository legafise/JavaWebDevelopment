package by.lashkevich.multithreading.service.aggregator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BooleanVariableMainMatrixDiagonalElementAggregatorTest {
    @DataProvider(name = "dataForFillingMainMatrixDiagonal")
    public Object[][] createDataForMainMatrixDiagonalFilling() {
        return new Object[][]{
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(12),
                        new SetMainMatrixDiagonalElementAggregator(4)), 4},
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(23)), 4},
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(5),
                        new SetMainMatrixDiagonalElementAggregator(8),
                        new SetMainMatrixDiagonalElementAggregator(9)), 4}
        };
    }

    @Test(description = "Positive scenario of matrix filling by method with boolean variable",
            dataProvider = "dataForFillingMainMatrixDiagonal")
    public void FillingMainMatrixDiagonalTest(List<SetMainMatrixDiagonalElementAggregator> aggregators,
                                              int expectedFillingNumber) throws InterruptedException {
        for (SetMainMatrixDiagonalElementAggregator currentAggregator : aggregators) {
            currentAggregator.start();
        }

        TimeUnit.MILLISECONDS.sleep(200);
        Assert.assertEquals(expectedFillingNumber, SetMainMatrixDiagonalElementAggregator.addCounter.get());
    }
}