package by.lashkevich.figures.service;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DistanceFinderTest {
    DistanceFinder distanceFinder;

    @DataProvider(name = "dataForFindingDistanceBetweenTwoPoints")
    public Object[][] createDataForFindingDistanceBetweenTwoPoints() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {Arrays.asList(tetrahedron.new Point(0, 0, 0), tetrahedron.new Point(2, -4, 3.4)),
                        5.61},
                {Arrays.asList(tetrahedron.new Point(0, 0, 0), tetrahedron.new Point(0,0,0)),
                        0},
        };
    }

    @BeforeMethod
    public void setUp() {
        distanceFinder = new DistanceFinder();
    }

    @Test(description = "Positive scenario of finding distance between two points",
            dataProvider = "dataForFindingDistanceBetweenTwoPoints")
    public void findDistanceBetweenTwoPointsTest(List<Tetrahedron.Point> points, double expectedDistance) {
        Assert.assertEquals(distanceFinder.findDistanceBetweenTwoPoints(points.get(0), points.get(1)),
                expectedDistance, 0.01);
    }
}