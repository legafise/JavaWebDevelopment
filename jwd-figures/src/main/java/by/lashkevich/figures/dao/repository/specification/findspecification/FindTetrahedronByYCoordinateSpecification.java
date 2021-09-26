package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByYCoordinateSpecification implements FindSpecification<Tetrahedron> {
    private double y;

    public FindTetrahedronByYCoordinateSpecification(double y) {
        this.y = y;
    }

    @Override
    public boolean isSpecified(Tetrahedron entity) {
        return entity.getFirstPoint().getY() == y || entity.getSecondPoint().getY() == y
                || entity.getThirdPoint().getY() == y || entity.getFourthPoint().getY() == y;
    }
}
