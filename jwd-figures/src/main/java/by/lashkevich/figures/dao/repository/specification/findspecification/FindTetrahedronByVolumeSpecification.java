package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;
import by.lashkevich.figures.service.DistanceFinder;

import java.util.function.ToDoubleFunction;

public class FindTetrahedronByVolumeSpecification implements FindSpecification<Tetrahedron> {
    private double minVolume;
    private double maxVolume;

    public FindTetrahedronByVolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean isSpecified(Tetrahedron entity) {
        DistanceFinder distanceFinder = new DistanceFinder();
        ToDoubleFunction<Tetrahedron> volumeFunction = machinedTetrahedron -> (Math.pow(distanceFinder.
                findDistanceBetweenTwoPoints(machinedTetrahedron.getSecondPoint(),
                        machinedTetrahedron.getFirstPoint()), 3) * Math.sqrt(2)) / 12;
        double volume = volumeFunction.applyAsDouble(entity);

        return minVolume < volume && volume < maxVolume;
    }
}
