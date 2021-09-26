package by.lashkevich.figures.dao.repository.specification.sortspecification;

import by.lashkevich.figures.entity.Tetrahedron;

import java.math.BigDecimal;
import java.util.Comparator;

public class SortTetrahedronByFirstPointYCoordinateSpecification implements SortSpecification<Tetrahedron> {
    @Override
    public Comparator<Tetrahedron> getComparator() {
        return Comparator.comparing(firstTetrahedron -> BigDecimal.valueOf(firstTetrahedron.getFirstPoint().getY()));
    }
}
