package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindTetrahedronByYCoordinateSpecificationTest {
    @DataProvider(name = "dataForPositiveYCoordinateValidation")
    public Object[][] createDataForPositiveYCoordinateValidation() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 0},
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 2.88},
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 8.66},
        };
    }

    @Test(description = "Positive scenario of tetrahedron y coordinate validation",
            dataProvider = "dataForPositiveYCoordinateValidation")
    public void findTetrahedronByYCoordinateTest(Tetrahedron tetrahedron, double yCoordinate) {
        Assert.assertTrue(new FindTetrahedronByYCoordinateSpecification(yCoordinate).isSpecified(tetrahedron));
    }
}