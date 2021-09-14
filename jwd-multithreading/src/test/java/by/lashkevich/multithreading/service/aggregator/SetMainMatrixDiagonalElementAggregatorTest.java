package by.lashkevich.multithreading.service.aggregator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SetMainMatrixDiagonalElementAggregatorTest {
    @DataProvider(name = "dataForFillingMainMatrixDiagonal")
    public Object[][] createDataForMainMatrixDiagonalFilling() {
        return new Object[][]{
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(2),
                        new SetMainMatrixDiagonalElementAggregator(62)), 4},
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(3)), 4},
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(7),
                        new SetMainMatrixDiagonalElementAggregator(18),
                        new SetMainMatrixDiagonalElementAggregator(35)), 4}
        };
    }

    @Test(description = "Positive scenario of matrix filling by method with Set",
            dataProvider = "dataForFillingMainMatrixDiagonal")
    public void FillingMainMatrixDiagonalTest(List<SetMainMatrixDiagonalElementAggregator> aggregators,
                                              int expectedFillingNumber) throws InterruptedException {
        for (SetMainMatrixDiagonalElementAggregator currentAggregator : aggregators) {
            currentAggregator.start();
        }

        TimeUnit.MILLISECONDS.sleep(200);
        Assert.assertEquals(expectedFillingNumber, SetMainMatrixDiagonalElementAggregator.addCounter);
    }
}