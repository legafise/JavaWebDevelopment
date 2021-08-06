package by.lashkevich.lb.service;

import by.lashkevich.lb.entity.Point;

/**
 * Service that executes the logic of the point checking tasks
 * @author Roman Lashkevich
 */
public interface PointService {
    boolean checkAPoint(Point point);
    boolean checkBPoint(Point point);
    boolean checkCPoint(Point point);
    String checkPointDistanceFromOrigin(Point firstPoint, Point secondPoint);
}
