package by.lashkevich.jwd.linearprogramutil.calculator;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleCalculatorTest {
    @DataProvider(name = "positiveDataForTriangleAreaCalculator")
    public Object[][] createPositiveDataForAreaCalculation() {
        return new Object[][]{
                {new double[]{0, 0, 0, 4, 3, 0}, 6},
                {new double[]{10, 10, 3, 4, 33, 8}, 75.9},
                {new double[]{6.4, 5.3, 7.7, 16.9, 3, 0}, 16.2},
                {new double[]{Double.MAX_VALUE, 0, 0, 4, 3, 0}, Double.NaN},
                {new double[]{0, Double.MAX_VALUE, 0, 4, 3, 0}, Double.NaN},
                {new double[]{0, 0, Double.MAX_VALUE, 4, 3, 0}, Double.NaN}
        };
    }

    @DataProvider(name = "positiveDataForTrianglePerimeterCalculator")
    public Object[][] createPositiveDataForPerimeterCalculation() {
        return new Object[][]{
                {new double[]{3, 4, 6, 23, 43, 0}, 103},
                {new double[]{34, 45, 24, 56, 34, 34}, 50},
                {new double[]{13, 5.3, 7.7, 16.9, 3.3, 0}, 41.2},
                {new double[]{4, Double.MAX_VALUE, 5, 2, 6, 0}, Double.POSITIVE_INFINITY},
                {new double[]{3, 6, Double.MAX_VALUE, 1, 3, 3}, Double.POSITIVE_INFINITY},
                {new double[]{1, 2, 5, Double.MAX_VALUE, 0, 3}, Double.POSITIVE_INFINITY}
        };
    }

    @Test(description = "Positive scenario of area calculation",
            dataProvider = "positiveDataForTriangleAreaCalculator")
    public void calculateAreaWithNormalValuesTest(double[] pointCoordinates, double expectedArea) {
        Point firstTestPoint = new Point(pointCoordinates[0], pointCoordinates[1]);
        Point secondTestPoint = new Point(pointCoordinates[2],pointCoordinates[3]);
        Point thirdTestPoint = new Point(pointCoordinates[4], pointCoordinates[5]);
        Triangle triangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
        Assert.assertEquals(TriangleCalculator.calculateArea(triangle), expectedArea, 0.1);
    }

    @Test(description = "Positive scenario of perimeter calculation",
            dataProvider = "positiveDataForTrianglePerimeterCalculator")
    public void calculatePerimeterPositiveTest(double[] pointCoordinates, double expectedPerimeter) {
        Point firstTestPoint = new Point(pointCoordinates[0], pointCoordinates[1]);
        Point secondTestPoint = new Point(pointCoordinates[2],pointCoordinates[3]);
        Point thirdTestPoint = new Point(pointCoordinates[4], pointCoordinates[5]);
        Triangle triangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
        Assert.assertEquals(TriangleCalculator.calculatePerimeter(triangle), expectedPerimeter, 0.1);
    }
}