package by.lashkevich.jwd.linearprogramutil.validator;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.lashkevich.jwd.linearprogramutil.validator.TriangleValidator.isValidTriangle;

public class TriangleValidatorTest {
    @DataProvider(name = "dataForTriangleValidation")
    public Object[][] createPositiveDataForAreaCalculation() {
        return new Object[][]{
                {new double[]{0, 0, 0, 4, 3, 0}, true},
                {new double[]{10, 10, 3, 4, 33, 8}, true},
                {new double[]{6.4, 5.3, 7.7, 16.9, 3, 0}, true},
                {new double[]{Double.MAX_VALUE, 0, 0, 4, 3, 0}, false},
                {new double[]{0, Double.MAX_VALUE, 0, 4, 3, 0}, false},
                {new double[]{0, 0, Double.MAX_VALUE, 4, 3, 0}, false}
        };
    }

    @Test(description = "Scenario for triangle validation",
            dataProvider = "dataForTriangleValidation")
    public void isValidTriangleTest(double[] pointCoordinates, boolean expectedResult) {
        Point firstTestPoint = new Point(pointCoordinates[0], pointCoordinates[1]);
        Point secondTestPoint = new Point(pointCoordinates[2], pointCoordinates[3]);
        Point thirdTestPoint = new Point(pointCoordinates[4], pointCoordinates[5]);
        Triangle testTriangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
        Assert.assertEquals(isValidTriangle(testTriangle), expectedResult);
    }
}