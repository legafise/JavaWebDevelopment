package by.lashkevich.jwd.util.calculator;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramValidatorException;
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
    public void calculateAreaPositiveTest() throws LinearProgramValidatorException {
        Assert.assertEquals(TriangleCalculator.calculateArea(positiveTestTriangle), expectedArea);
    }

    @Test
    public void calculateAreaNegativeTest() throws LinearProgramValidatorException {
        expectedArea = 4;
        Assert.assertNotEquals(TriangleCalculator.calculateArea(positiveTestTriangle), expectedArea);
    }

    @Test (expectedExceptions = LinearProgramValidatorException.class)
    public void calculateAreaWithInvalidTriangleTest() throws LinearProgramValidatorException {
        Assert.assertNotEquals(TriangleCalculator.calculateArea(negativeTestTriangle), expectedArea);
    }

    @Test
    public void calculatePerimeterPositiveTest() throws LinearProgramValidatorException {
        Assert.assertEquals(TriangleCalculator.calculatePerimeter(positiveTestTriangle), expectedPerimeter);
    }

    @Test
    public void calculatePerimeterNegativeTest() throws LinearProgramValidatorException {
        expectedPerimeter = 4;
        Assert.assertNotEquals(TriangleCalculator.calculatePerimeter(positiveTestTriangle), expectedPerimeter);
    }

    @Test (expectedExceptions = LinearProgramValidatorException.class)
    public void calculatePerimeterWithInvalidTriangleTest() throws LinearProgramValidatorException {
        Assert.assertEquals(TriangleCalculator.calculatePerimeter(negativeTestTriangle), expectedPerimeter);
    }
}