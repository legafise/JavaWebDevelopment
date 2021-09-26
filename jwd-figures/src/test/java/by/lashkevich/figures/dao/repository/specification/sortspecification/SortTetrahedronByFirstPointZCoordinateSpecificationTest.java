package by.lashkevich.figures.dao.repository.specification.sortspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SortTetrahedronByFirstPointZCoordinateSpecificationTest {
    @DataProvider(name = "dataForFirstPointZCoordinateSorting")
    public Object[][] createDataForFirstPointZCoordinateSorting() {
        Tetrahedron tetrahedron = new Tetrahedron();
        return new Object[][]{
                {Arrays.asList(new Tetrahedron(tetrahedron.new Point(0, 415, 909),
                                tetrahedron.new Point(0, 414.03, 910.75),
                                tetrahedron.new Point(413, 909.04, 0),
                                tetrahedron.new Point(13.24, 7.34, 1.41)),
                        new Tetrahedron(tetrahedron.new Point(24, 0, 1),
                                tetrahedron.new Point(241.54, 0, -887.76),
                                tetrahedron.new Point(902.45, 0, -255.01),
                                tetrahedron.new Point(389.32, 747.09, -380.58))),
                        Arrays.asList(new Tetrahedron(tetrahedron.new Point(24, 0, 1),
                                        tetrahedron.new Point(241.54, 0, -887.76),
                                        tetrahedron.new Point(902.45, 0, -255.01),
                                        tetrahedron.new Point(389.32, 747.09, -380.58)),
                                new Tetrahedron(tetrahedron.new Point(0, 415, 909),
                                        tetrahedron.new Point(0, 414.03, 910.75),
                                        tetrahedron.new Point(413, 909.04, 0),
                                        tetrahedron.new Point(13.24, 7.34, 1.41)))
                },
        };
    }

    @Test(description = "Different scenario of tetrahedron first point z coordinate sorting",
            dataProvider = "dataForFirstPointZCoordinateSorting")
    public void sortTetrahedronByVolumeTest(List<Tetrahedron> tetrahedronTestList, List<Tetrahedron> expectedResult) {
        tetrahedronTestList.sort(new SortTetrahedronByFirstPointZCoordinateSpecification().getComparator());
        Assert.assertEquals(tetrahedronTestList, expectedResult);
    }
}