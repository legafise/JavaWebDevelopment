package by.lashkevich.jwd.linearprogramutil.validator;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static by.lashkevich.jwd.linearprogramutil.validator.TriangleValidator.isValidTriangle;

public class TriangleValidatorTest {
    private Triangle positiveTestTriangle;
    private Triangle negativeTestTriangle;

    @BeforeMethod
    public void setUp() {
        Point firstTestPoint = new Point(0, 0);
        Point secondTestPoint = new Point(0,4);
        Point thirdTestPoint = new Point(3, 0);
        positiveTestTriangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
        negativeTestTriangle = new Triangle(firstTestPoint, secondTestPoint, firstTestPoint);
    }

    @Test
    public void isValidTrianglePositiveTest() {
        Assert.assertTrue(isValidTriangle(positiveTestTriangle));
    }

    @Test
    public void isValidTriangleNegativeTest() {
        Assert.assertFalse(isValidTriangle(negativeTestTriangle));
    }
}