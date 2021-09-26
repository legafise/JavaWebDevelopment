package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByBaseInZPlaneSpecification implements FindSpecification<Tetrahedron> {
    @Override
    public boolean isSpecified(Tetrahedron entity) {
        int zCoordinateCounter = 0;
        
        if (entity.getFirstPoint().getZ() == 0) {
            zCoordinateCounter++;
        }

        if (entity.getFirstPoint().getZ() == 0) {
            zCoordinateCounter++;
        }

        if (entity.getSecondPoint().getZ() == 0) {
            zCoordinateCounter++;
        }
        
        if (entity.getThirdPoint().getZ() == 0) {
            zCoordinateCounter++;
        }

        if (entity.getThirdPoint().getZ() == 0) {
            zCoordinateCounter++;
        }
        
        return zCoordinateCounter >= 3;
    }
}
