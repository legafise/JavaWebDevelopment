package by.lashkevich.jwd.util.calculator.impl;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.TriangleValidatorException;
import by.lashkevich.jwd.util.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleCalculatorTest {
    private Calculator calculator;
    private Point firstTestPoint;
    private Point secondTestPoint;
    private Point thirdTestPoint;
    private Triangle positiveTestTriangle;
    private Triangle negativeTestTriangle;
    private double expectedArea;
    private double expectedPerimeter;

    @BeforeMethod
    public void setUp() {
        firstTestPoint = new Point(0, 0);
        secondTestPoint = new Point(0,4);
        thirdTestPoint = new Point(3, 0);
        positiveTestTriangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
        negativeTestTriangle = new Triangle(firstTestPoint, secondTestPoint, firstTestPoint);
        calculator = new TriangleCalculator();
        expectedArea = 6;
        expectedPerimeter = 12;
    }

    @Test
    public void calculateAreaPositiveTest() throws TriangleValidatorException {
        Assert.assertEquals(calculator.calculateArea(positiveTestTriangle), expectedArea);
    }

    @Test
    public void calculateAreaNegativeTest() throws TriangleValidatorException {
        expectedArea = 4;
        Assert.assertNotEquals(calculator.calculateArea(positiveTestTriangle), expectedArea);
    }

    @Test (expectedExceptions = TriangleValidatorException.class)
    public void calculateAreaWithInvalidTriangleTest() throws TriangleValidatorException {
        Assert.assertNotEquals(calculator.calculateArea(negativeTestTriangle), expectedArea);
    }

    @Test
    public void calculatePerimeterPositiveTest() throws TriangleValidatorException {
        Assert.assertEquals(calculator.calculatePerimeter(positiveTestTriangle), expectedPerimeter);
    }

    @Test
    public void calculatePerimeterNegativeTest() throws TriangleValidatorException {
        expectedPerimeter = 4;
        Assert.assertNotEquals(calculator.calculatePerimeter(positiveTestTriangle), expectedPerimeter);
    }

    @Test (expectedExceptions = TriangleValidatorException.class)
    public void calculatePerimeterWithInvalidTriangleTest() throws TriangleValidatorException {
        Assert.assertEquals(calculator.calculatePerimeter(negativeTestTriangle), expectedPerimeter);
    }
}