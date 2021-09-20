package by.lashkevich.figures.service;

import by.lashkevich.figures.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataParser {
    private static final String TETRAHEDRON_SEPARATION_SING = "TetrahedronInfo";
    private static final String POINT_SEPARATION_SING = " ";

    public List<Tetrahedron> parseTetrahedron(List<String> data) {
        Iterator<String> dataIterator = data.iterator();
        List<Tetrahedron> tetrahedronList = new ArrayList<>();
        while (dataIterator.hasNext()) {
            if (dataIterator.next().equals(TETRAHEDRON_SEPARATION_SING)) {
                Tetrahedron tetrahedron = new Tetrahedron();
                tetrahedron.setFirstPoint(parsePoint(dataIterator, tetrahedron));
                tetrahedron.setSecondPoint(parsePoint(dataIterator, tetrahedron));
                tetrahedron.setThirdPoint(parsePoint(dataIterator, tetrahedron));
                tetrahedron.setFourthPoint(parsePoint(dataIterator, tetrahedron));
                tetrahedronList.add(tetrahedron);
            }
        }

        return tetrahedronList;
    }

    private Tetrahedron.Point parsePoint(Iterator<String> data, Tetrahedron tetrahedron) {
        List<String> pointsData = Arrays.asList(data.next().split(POINT_SEPARATION_SING));
        Iterator<String> pointsDataIterator = pointsData.iterator();
        Tetrahedron.Point point = tetrahedron.new Point();

        while (pointsDataIterator.hasNext()) {
            point.setX(Double.parseDouble(pointsDataIterator.next()));
            point.setY(Double.parseDouble(pointsDataIterator.next()));
            point.setZ(Double.parseDouble(pointsDataIterator.next()));
        }

        return point;
    }
}
