package by.lashkevich.figures.service;

import by.lashkevich.figures.entity.Tetrahedron;

public class DistanceFinder {
    public double findDistanceBetweenTwoPoints(Tetrahedron.Point firstPoint, Tetrahedron.Point secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2)
                + Math.pow(secondPoint.getY() - firstPoint.getY(), 2)
                + Math.pow(secondPoint.getZ() - firstPoint.getZ(), 2));
    }
}
