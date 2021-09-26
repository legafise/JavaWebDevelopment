package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindTetrahedronByBaseInZPlaneSpecificationTest {
    @DataProvider(name = "dataForBaseInZPlaneValidation")
    public Object[][] createDataForBaseInZPlaneValidation() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), true},
                {new Tetrahedron(tetrahedron.new Point(0, 415, 909),
                        tetrahedron.new Point(0, 414.03, 910.75), tetrahedron.new Point(413, 909.04, 0),
                        tetrahedron.new Point(1.63, 414.01, 909.59)), false},
        };
    }

    @Test(description = "Positive and bad scenario of tetrahedron base in z plane validation",
            dataProvider = "dataForBaseInZPlaneValidation")
    public void findTetrahedronByBaseInXPlaneTest(Tetrahedron tetrahedron, boolean expectedResult) {
        Assert.assertEquals(new FindTetrahedronByBaseInZPlaneSpecification().isSpecified(tetrahedron), expectedResult);
    }
}