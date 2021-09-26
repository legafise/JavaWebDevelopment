package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindTetrahedronByIdSpecificationTest {
    @DataProvider(name = "dataForPositiveIdValidation")
    public Object[][] createDataForPositiveIdValidation() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {new Tetrahedron(0, tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 0},
                {new Tetrahedron(1, tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), 1}};
    }


    @Test(description = "Positive scenario of tetrahedron id validation",
            dataProvider = "dataForPositiveIdValidation")
    public void findTetrahedronByIdTest(Tetrahedron tetrahedron, long id) {
        Assert.assertTrue(new FindTetrahedronByIdSpecification(id).isSpecified(tetrahedron));
    }
}