package by.lashkevich.jwd.util.finder;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static by.lashkevich.jwd.util.finder.SideFinder.findTriangleSide;

public class SideFinderTest {
    private double firstExpectedSide;
    private double secondExpectedSide;
    private double thirdExpectedSide;
    private List<Double> expectedSides;
    private Point firstTestPoint;
    private Point secondTestPoint;
    private Point thirdTestPoint;
    private Triangle testTriangle;

    @BeforeMethod
    public void setUp() {
        firstExpectedSide = 4;
        secondExpectedSide = 5;
        thirdExpectedSide = 3;
        expectedSides = Arrays.asList(firstExpectedSide, secondExpectedSide, thirdExpectedSide);

        firstTestPoint = new Point(0, 0);
        secondTestPoint = new Point(0,4);
        thirdTestPoint = new Point(3, 0);
        testTriangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
    }

    @Test
    public void FindTriangleSidePositiveTest() {
        Assert.assertEquals(findTriangleSide(testTriangle), expectedSides);
    }

    @Test
    public void FindTriangleSideNegativeTest() {
        testTriangle.setFirstPoint(thirdTestPoint);
        Assert.assertNotEquals(findTriangleSide(testTriangle), expectedSides);
    }
}