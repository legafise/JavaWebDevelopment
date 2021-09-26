package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindTetrahedronByBaseInYPlaneSpecificationTest {
    @DataProvider(name = "dataForBaseInYPlaneValidation")
    public Object[][] createDataForBaseInZPlaneValidation() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {new Tetrahedron(tetrahedron.new Point(10, 0, 3),
                        tetrahedron.new Point(18.4, 0, -0.22), tetrahedron.new Point(11.38, 0, -5.89),
                        tetrahedron.new Point(13.24, 7.34, 1.41)), true},
                {new Tetrahedron(tetrahedron.new Point(0, 415, 909),
                        tetrahedron.new Point(0, 414.03, 910.75), tetrahedron.new Point(413, 909.04, 0),
                        tetrahedron.new Point(13.24, 7.34, 1.41)), false},
        };
    }

    @Test(description = "Positive and bad scenario of tetrahedron base in y plane validation",
            dataProvider = "dataForBaseInYPlaneValidation")
    public void findTetrahedronByBaseInXPlaneTest(Tetrahedron tetrahedron, boolean expectedResult) {
        Assert.assertEquals(new FindTetrahedronByBaseInYPlaneSpecification().isSpecified(tetrahedron), expectedResult);
    }
}