package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindTetrahedronByZCoordinateSpecificationTest {
    @DataProvider(name = "dataForPositiveZCoordinateValidation")
    public Object[][] createDataForPositiveZCoordinateValidation() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 0},
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 0},
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 8.16},
        };
    }

    @Test(description = "Positive scenario of tetrahedron z coordinate validation",
            dataProvider = "dataForPositiveZCoordinateValidation")
    public void findTetrahedronByZCoordinateTest(Tetrahedron tetrahedron, double zCoordinate) {
        Assert.assertTrue(new FindTetrahedronByZCoordinateSpecification(zCoordinate).isSpecified(tetrahedron));
    }
}