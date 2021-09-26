package by.lashkevich.figures.dao.repository.specification.sortspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SortTetrahedronByIdSpecificationTest {
    @DataProvider(name = "dataForIdSorting")
    public Object[][] createDataForAreaSorting() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {Arrays.asList(new Tetrahedron(2, tetrahedron.new Point(0, 0, 0),
                                tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                                tetrahedron.new Point(5, 2.88, 8.16)),
                        new Tetrahedron(1, tetrahedron.new Point(10, 0, 3),
                                tetrahedron.new Point(18.4, 0, -0.22),
                                tetrahedron.new Point(11.38, 0, -5.89),
                                tetrahedron.new Point(13.24, 7.34, 1.41)),
                        new Tetrahedron(0, tetrahedron.new Point(0, 415, 909),
                                tetrahedron.new Point(0, 414.03, 910.75),
                                tetrahedron.new Point(413, 909.04, 0),
                                tetrahedron.new Point(13.24, 7.34, 1.41))),
                        Arrays.asList(new Tetrahedron(0, tetrahedron.new Point(0, 415, 909),
                                        tetrahedron.new Point(0, 414.03, 910.75),
                                        tetrahedron.new Point(413, 909.04, 0),
                                        tetrahedron.new Point(13.24, 7.34, 1.41)),
                                new Tetrahedron(1, tetrahedron.new Point(10, 0, 3),
                                        tetrahedron.new Point(18.4, 0, -0.22),
                                        tetrahedron.new Point(11.38, 0, -5.89),
                                        tetrahedron.new Point(13.24, 7.34, 1.41)),
                                new Tetrahedron(2, tetrahedron.new Point(0, 0, 0),
                                        tetrahedron.new Point(5, 8.66, 0),
                                        tetrahedron.new Point(10, 0, 0),
                                        tetrahedron.new Point(5, 2.88, 8.16)))},
        };
    }

    @Test(description = "Different scenario of tetrahedron id sorting",
            dataProvider = "dataForIdSorting")
    public void sortTetrahedronByIdTest(List<Tetrahedron> tetrahedronTestList, List<Tetrahedron> expectedResult) {
        tetrahedronTestList.sort(new SortTetrahedronByIdSpecification().getComparator());
        Assert.assertEquals(tetrahedronTestList, expectedResult);
    }
}