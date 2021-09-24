package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByXCoordinateSpecification implements FindSpecification<Tetrahedron> {
    private double x;

    public FindTetrahedronByXCoordinateSpecification(double x) {
        this.x = x;
    }

    @Override
    public boolean isSpecified(Tetrahedron entity) {
        return entity.getFirstPoint().getX() == x || entity.getSecondPoint().getX() == x
                || entity.getThirdPoint().getX() == x || entity.getFourthPoint().getX() == x;
    }
}
