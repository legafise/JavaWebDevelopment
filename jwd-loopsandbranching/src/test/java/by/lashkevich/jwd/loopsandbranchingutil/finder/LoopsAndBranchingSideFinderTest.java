package by.lashkevich.jwd.loopsandbranchingutil.finder;

import by.lashkevich.lb.entity.Point;
import by.lashkevich.lb.entity.Triangle;
import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingSideFinder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LoopsAndBranchingSideFinderTest {
    @DataProvider(name = "positiveDataForTriangleSideFinder")
    public Object[][] createPositiveDataForSideFinding() {
        return new Object[][]{
                {new double[]{0, 0, 0, 4, 3, 0},
                        Arrays.asList(4.0, 5.0, 3.0)},
                {new double[]{10, 10, 3, 4, 33, 8},
                        Arrays.asList(9.219544457292887, 30.265491900843113, 23.08679276123039)},
                {new double[]{6.4, 5.3, 7.7, 16.9, 3, 0},
                        Arrays.asList(11.67261752992875, 17.541379649275022, 6.296824596572467)},
        };
    }

    @Test(description = "Positive scenario of side finding",
            dataProvider = "positiveDataForTriangleSideFinder")
    public void FindTriangleSideTest(double[] pointCoordinates, List<Double> expectedSides) {
        Point firstTestPoint = new Point(pointCoordinates[0], pointCoordinates[1]);
        Point secondTestPoint = new Point(pointCoordinates[2],pointCoordinates[3]);
        Point thirdTestPoint = new Point(pointCoordinates[4], pointCoordinates[5]);
        Triangle triangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
        Assert.assertEquals(LoopsAndBranchingSideFinder.findTriangleSide(triangle), expectedSides);
    }
}