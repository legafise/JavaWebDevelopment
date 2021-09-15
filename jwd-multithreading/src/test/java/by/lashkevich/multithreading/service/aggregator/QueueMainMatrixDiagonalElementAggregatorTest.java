package by.lashkevich.multithreading.service.aggregator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QueueMainMatrixDiagonalElementAggregatorTest {
    @DataProvider(name = "dataForFillingMainMatrixDiagonal")
    public Object[][] createDataForMainMatrixDiagonalFilling() {
        return new Object[][]{
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(8),
                        new SetMainMatrixDiagonalElementAggregator(8)), 4},
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(34)), 4},
                {Arrays.asList(new SetMainMatrixDiagonalElementAggregator(6),
                        new SetMainMatrixDiagonalElementAggregator(6),
                        new SetMainMatrixDiagonalElementAggregator(15)), 4}
        };
    }

    @Test(description = "Positive scenario of matrix filling by method with queue",
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