package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByZCoordinateSpecification implements FindSpecification<Tetrahedron> {
    private double z;

    public FindTetrahedronByZCoordinateSpecification(double z) {
        this.z = z;
    }

    @Override
    public boolean isSpecified(Tetrahedron entity) {
        return entity.getFirstPoint().getX() == z || entity.getSecondPoint().getX() == z
                || entity.getThirdPoint().getX() == z || entity.getFourthPoint().getX() == z;
    }
}
