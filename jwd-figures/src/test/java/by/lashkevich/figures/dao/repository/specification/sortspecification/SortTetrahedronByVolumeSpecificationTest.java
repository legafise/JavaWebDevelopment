package by.lashkevich.figures.dao.repository.specification.sortspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SortTetrahedronByVolumeSpecificationTest {
    @DataProvider(name = "dataForVolumeSorting")
    public Object[][] createDataForVolumeSorting() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {Arrays.asList(new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                                tetrahedron.new Point(5, 8.66, 0), tetrahedron.new Point(10, 0, 0),
                                tetrahedron.new Point(5, 2.88, 8.16)),
                        new Tetrahedron(tetrahedron.new Point(0, 415, 909),
                                tetrahedron.new Point(0, 414.03, 910.75),
                                tetrahedron.new Point(413, 909.04, 0),
                                tetrahedron.new Point(13.24, 7.34, 1.41))),
                        Arrays.asList(new Tetrahedron(tetrahedron.new Point(0, 415, 909),
                                        tetrahedron.new Point(0, 414.03, 910.75),
                                        tetrahedron.new Point(413, 909.04, 0),
                                        tetrahedron.new Point(13.24, 7.34, 1.41)),
                                new Tetrahedron(tetrahedron.new Point(0, 0, 0),
                                        tetrahedron.new Point(5, 8.66, 0),
                                        tetrahedron.new Point(10, 0, 0),
                                        tetrahedron.new Point(5, 2.88, 8.16)))},
        };
    }

    @Test(description = "Different scenario of tetrahedron volume sorting",
            dataProvider = "dataForVolumeSorting")
    public void sortTetrahedronByVolumeTest(List<Tetrahedron> tetrahedronTestList, List<Tetrahedron> expectedResult) {
        tetrahedronTestList.sort(new SortTetrahedronByVolumeSpecification().getComparator());
        Assert.assertEquals(tetrahedronTestList, expectedResult);
    }
}