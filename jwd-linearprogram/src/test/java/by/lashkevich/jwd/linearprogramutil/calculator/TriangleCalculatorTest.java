package by.lashkevich.jwd.linearprogramutil.calculator;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleCalculatorTest {
    private Triangle positiveTestTriangle;
    private Triangle negativeTestTriangle;
    private double expectedArea;
    private double expectedPerimeter;

    @BeforeMethod
    public void setUp() {
        Point firstTestPoint = new Point(0, 0);
        Point secondTestPoint = new Point(0,4);
        Point thirdTestPoint = new Point(3, 0);
        positiveTestTriangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
        negativeTestTriangle = new Triangle(firstTestPoint, secondTestPoint, firstTestPoint);
        expectedArea = 6;
        expectedPerimeter = 12;
    }

    @Test
    public void calculateAreaPositiveTest() {
        Assert.assertEquals(TriangleCalculator.calculateArea(positiveTestTriangle), expectedArea);
    }

    @Test
    public void calculateAreaNegativeTest() {
        expectedArea = 4;
        Assert.assertNotEquals(TriangleCalculator.calculateArea(positiveTestTriangle), expectedArea);
    }

    @Test
    public void calculatePerimeterPositiveTest() {
        Assert.assertEquals(TriangleCalculator.calculatePerimeter(positiveTestTriangle), expectedPerimeter);
    }

    @Test
    public void calculatePerimeterNegativeTest() {
        expectedPerimeter = 4;
        Assert.assertNotEquals(TriangleCalculator.calculatePerimeter(positiveTestTriangle), expectedPerimeter);
    }
}