package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByPointSpecification implements FindSpecification<Tetrahedron> {
    private Tetrahedron.Point point;

    public FindTetrahedronByPointSpecification(Tetrahedron.Point point) {
        this.point = point;
    }

    @Override
    public boolean isSpecified(Tetrahedron entity) {
        return entity.getFirstPoint().equals(point) || entity.getSecondPoint().equals(point)
                || entity.getThirdPoint().equals(point) || entity.getFourthPoint().equals(point) ;
    }
}
