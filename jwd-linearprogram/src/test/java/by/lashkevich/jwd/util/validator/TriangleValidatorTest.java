package by.lashkevich.jwd.util.validator;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.TriangleValidatorException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static by.lashkevich.jwd.util.validator.TriangleValidator.isValidTriangle;

public class TriangleValidatorTest {
    private Point firstTestPoint;
    private Point secondTestPoint;
    private Point thirdTestPoint;
    private Triangle positiveTestTriangle;
    private Triangle negativeTestTriangle;

    @BeforeMethod
    public void setUp() {
        firstTestPoint = new Point(0, 0);
        secondTestPoint = new Point(0,4);
        thirdTestPoint = new Point(3, 0);
        positiveTestTriangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
        negativeTestTriangle = new Triangle(firstTestPoint, secondTestPoint, firstTestPoint);
    }

    @Test
    public void isValidTrianglePositiveTest() throws TriangleValidatorException {
        isValidTriangle(positiveTestTriangle);
    }

    @Test (expectedExceptions = TriangleValidatorException.class)
    public void isValidTriangleNegativeTest() throws TriangleValidatorException {
        isValidTriangle(negativeTestTriangle);
    }
}