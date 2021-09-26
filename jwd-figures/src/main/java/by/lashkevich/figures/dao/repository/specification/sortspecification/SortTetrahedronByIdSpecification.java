package by.lashkevich.figures.dao.repository.specification.sortspecification;

import by.lashkevich.figures.entity.Tetrahedron;

import java.util.Comparator;

public class SortTetrahedronByIdSpecification implements SortSpecification<Tetrahedron> {
    @Override
    public Comparator<Tetrahedron> getComparator() {
        return Comparator.comparing(Tetrahedron::getId);
    }
}
