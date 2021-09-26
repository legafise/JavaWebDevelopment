package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByBaseInYPlaneSpecification implements FindSpecification<Tetrahedron> {
    @Override
    public boolean isSpecified(Tetrahedron entity) {
        int yCoordinateCounter = 0;
        
        if (entity.getFirstPoint().getY() == 0) {
            yCoordinateCounter++;
        }

        if (entity.getFirstPoint().getY() == 0) {
            yCoordinateCounter++;
        }

        if (entity.getSecondPoint().getY() == 0) {
            yCoordinateCounter++;
        }
        
        if (entity.getThirdPoint().getY() == 0) {
            yCoordinateCounter++;
        }

        if (entity.getThirdPoint().getY() == 0) {
            yCoordinateCounter++;
        }
        
        return yCoordinateCounter >= 3;
    }
}
