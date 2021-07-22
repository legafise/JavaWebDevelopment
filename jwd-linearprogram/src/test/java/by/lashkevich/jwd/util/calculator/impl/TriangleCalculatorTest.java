package by.lashkevich.jwd.util.calculator.impl;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.TriangleCalculatorException;
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
    public void calculateAreaPositiveTest() throws TriangleCalculatorException {
        Assert.assertEquals(calculator
                .calculateArea(positiveTestTriangle), expectedArea);
    }

    @Test
    public void calculateAreaNegativeTest() throws TriangleCalculatorException {
        expectedArea = 4;
        Assert.assertNotEquals(calculator
                .calculateArea(positiveTestTriangle), expectedArea);
    }

    @Test (expectedExceptions = TriangleCalculatorException.class)
    public void calculateAreaWithInvalidTriangleTest() throws TriangleCalculatorException {
        Assert.assertNotEquals(calculator
                .calculateArea(negativeTestTriangle), expectedArea);
    }

    @Test
    public void calculatePerimeterPositiveTest() throws TriangleCalculatorException {
        Assert.assertEquals(calculator
                .calculatePerimeter(positiveTestTriangle), expectedPerimeter);
    }

    @Test
    public void calculatePerimeterNegativeTest() throws TriangleCalculatorException {
        expectedPerimeter = 4;
        Assert.assertNotEquals(calculator
                .calculatePerimeter(positiveTestTriangle), expectedPerimeter);
    }

    @Test (expectedExceptions = TriangleCalculatorException.class)
    public void calculatePerimeterWithInvalidTriangleTest() throws TriangleCalculatorException {
        Assert.assertEquals(calculator
                .calculatePerimeter(negativeTestTriangle), expectedPerimeter);
    }
}