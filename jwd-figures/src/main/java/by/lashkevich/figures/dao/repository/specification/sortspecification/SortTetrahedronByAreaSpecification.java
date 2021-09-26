package by.lashkevich.figures.dao.repository.specification.sortspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import by.lashkevich.figures.service.DistanceFinder;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.function.ToDoubleFunction;

public class SortTetrahedronByAreaSpecification implements SortSpecification<Tetrahedron> {
    @Override
    public Comparator<Tetrahedron> getComparator() {
        DistanceFinder distanceFinder = new DistanceFinder();
        ToDoubleFunction<Tetrahedron> areaFunction = machinedTetrahedron -> Math.sqrt(3) * Math.pow(distanceFinder.
                findDistanceBetweenTwoPoints(machinedTetrahedron.getSecondPoint(),
                        machinedTetrahedron.getFirstPoint()), 2);

        return Comparator.comparing(tetrahedron -> BigDecimal.valueOf(areaFunction.applyAsDouble(tetrahedron)));
    }
}
