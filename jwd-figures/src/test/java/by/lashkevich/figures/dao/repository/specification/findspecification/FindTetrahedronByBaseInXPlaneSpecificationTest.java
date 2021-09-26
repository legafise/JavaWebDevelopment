package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindTetrahedronByBaseInXPlaneSpecificationTest {
    @DataProvider(name = "dataForBaseInXPlaneValidation")
    public Object[][] createDataForBaseInXPlaneValidation() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                        tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                        tetrahedron.new Point(5, 2.88, 8.16)), false},
                {new Tetrahedron(tetrahedron.new Point(0, 415, 909),
                        tetrahedron.new Point(0, 414.03, 910.75), tetrahedron.new Point(413, 909.04, 0),
                        tetrahedron.new Point(1.63, 414.01, 909.59)), true},
        };
    }

    @Test(description = "Positive and bad scenario of tetrahedron base in x plane validation",
            dataProvider = "dataForBaseInXPlaneValidation")
    public void findTetrahedronByBaseInXPlaneTest(Tetrahedron tetrahedron, boolean expectedResult) {
        Assert.assertEquals(new FindTetrahedronByBaseInXPlaneSpecification().isSpecified(tetrahedron), expectedResult);
    }
}