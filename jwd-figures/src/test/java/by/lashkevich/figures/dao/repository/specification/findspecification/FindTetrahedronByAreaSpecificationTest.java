package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class FindTetrahedronByAreaSpecificationTest {
    @DataProvider(name = "dataForPositiveAreaValidation")
    public Object[][] createDataForPositiveAreaValidation() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), new double[]{150, 180}},
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), new double[]{Double.MIN_VALUE, Double.MAX_VALUE}},
        };
    }

    @Test(description = "Positive scenario of tetrahedron area validation",
            dataProvider = "dataForPositiveAreaValidation")
    public void findTetrahedronByAreaTest(Tetrahedron tetrahedron, double[] areas) {
        Assert.assertTrue(new FindTetrahedronByAreaSpecification(areas[0], areas[1]).isSpecified(tetrahedron));
    }
}