package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByZCoordinateSpecification implements FindSpecification<Tetrahedron> {
    private double z;

    public FindTetrahedronByZCoordinateSpecification(double z) {
        this.z = z;
    }

    @Override
    public boolean isSpecified(Tetrahedron entity) {
        return entity.getFirstPoint().getZ() == z || entity.getSecondPoint().getZ() == z
                || entity.getThirdPoint().getZ() == z || entity.getFourthPoint().getZ() == z;
    }
}
