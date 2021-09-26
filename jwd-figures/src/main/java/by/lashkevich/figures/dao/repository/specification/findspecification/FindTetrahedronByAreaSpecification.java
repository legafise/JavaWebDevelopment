package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import by.lashkevich.figures.service.DistanceFinder;

import java.util.function.ToDoubleFunction;

public class FindTetrahedronByAreaSpecification implements FindSpecification<Tetrahedron> {
    private double minArea;
    private double maxArea;

    public FindTetrahedronByAreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean isSpecified(Tetrahedron entity) {
        DistanceFinder distanceFinder = new DistanceFinder();
        ToDoubleFunction<Tetrahedron> areaFunction = machinedTetrahedron -> Math.sqrt(3) * Math.pow(distanceFinder.
                findDistanceBetweenTwoPoints(machinedTetrahedron.getSecondPoint(),
                        machinedTetrahedron.getFirstPoint()), 2);
        double area = areaFunction.applyAsDouble(entity);

        return minArea < area && maxArea > area;
    }
}
