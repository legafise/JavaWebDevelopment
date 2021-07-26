package by.lashkevich.jwd.linearprogramutil.finder;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static by.lashkevich.jwd.linearprogramutil.finder.SideFinder.findTriangleSide;

public class SideFinderTest {
    private List<Double> expectedSides;
    private Point thirdTestPoint;
    private Triangle testTriangle;

    @BeforeMethod
    public void setUp() {
        double firstExpectedSide = 4;
        double secondExpectedSide = 5;
        double thirdExpectedSide = 3;
        expectedSides = Arrays.asList(firstExpectedSide, secondExpectedSide, thirdExpectedSide);

        Point firstTestPoint = new Point(0, 0);
        Point secondTestPoint = new Point(0,4);
        thirdTestPoint = new Point(3, 0);
        testTriangle = new Triangle(firstTestPoint, secondTestPoint, thirdTestPoint);
    }

    @Test
    public void FindTriangleSidePositiveTest() {
        Assert.assertEquals(findTriangleSide(testTriangle), expectedSides);
        Assert.fail();
    }

    @Test
    public void FindTriangleSideNegativeTest() {
        testTriangle.setFirstPoint(thirdTestPoint);
        Assert.assertNotEquals(findTriangleSide(testTriangle), expectedSides);
    }
}