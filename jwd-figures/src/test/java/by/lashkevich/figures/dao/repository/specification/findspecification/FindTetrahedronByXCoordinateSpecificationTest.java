package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindTetrahedronByXCoordinateSpecificationTest {
    @DataProvider(name = "dataForPositiveXCoordinateValidation")
    public Object[][] createDataForPositiveXCoordinateValidation() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 0},
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 5},
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 10},
        };
    }

    @Test(description = "Positive scenario of tetrahedron x coordinate validation",
            dataProvider = "dataForPositiveXCoordinateValidation")
    public void findTetrahedronByXCoordinateTest(Tetrahedron tetrahedron, double xCoordinate) {
        Assert.assertTrue(new FindTetrahedronByXCoordinateSpecification(xCoordinate).isSpecified(tetrahedron));
    }
}