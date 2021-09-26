package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByBaseInXPlaneSpecification implements FindSpecification<Tetrahedron> {
    @Override
    public boolean isSpecified(Tetrahedron entity) {
        int xCoordinateCounter = 0;

        if (entity.getFirstPoint().getX() == 0) {
            xCoordinateCounter++;
        }

        if (entity.getFirstPoint().getX() == 0) {
            xCoordinateCounter++;
        }

        if (entity.getSecondPoint().getX() == 0) {
            xCoordinateCounter++;
        }

        if (entity.getThirdPoint().getX() == 0) {
            xCoordinateCounter++;
        }

        if (entity.getThirdPoint().getX() == 0) {
            xCoordinateCounter++;
        }

        return xCoordinateCounter >= 3;
    }
}
