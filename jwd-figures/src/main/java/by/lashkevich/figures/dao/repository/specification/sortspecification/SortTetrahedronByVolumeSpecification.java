package by.lashkevich.figures.dao.repository.specification.sortspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import by.lashkevich.figures.service.DistanceFinder;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.function.ToDoubleFunction;

public class SortTetrahedronByVolumeSpecification implements SortSpecification<Tetrahedron> {
    @Override
    public Comparator<Tetrahedron> getComparator() {
        DistanceFinder distanceFinder = new DistanceFinder();
        ToDoubleFunction<Tetrahedron> volumeFunction = machinedTetrahedron -> (Math.pow(distanceFinder.
                findDistanceBetweenTwoPoints(machinedTetrahedron.getSecondPoint(),
                        machinedTetrahedron.getFirstPoint()), 3) * Math.sqrt(2)) / 12;

        return Comparator.comparing(tetrahedron -> BigDecimal.valueOf(volumeFunction.applyAsDouble(tetrahedron)));
    }
}
