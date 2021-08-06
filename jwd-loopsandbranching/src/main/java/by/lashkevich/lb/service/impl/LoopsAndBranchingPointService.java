package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.entity.Point;
import by.lashkevich.lb.loopsandbranchingutil.checker.LoopsAndBranchingPointChecker;
import by.lashkevich.lb.service.PointService;

/**
 * @see by.lashkevich.lb.service.PointService
 * @author Roman Lashkevich
 */
public class LoopsAndBranchingPointService implements PointService {
    @Override
    public boolean checkAPoint(Point point) {
        return LoopsAndBranchingPointChecker.checkAPoint(point.getX(), point.getY());
    }

    @Override
    public boolean checkBPoint(Point point) {
        return LoopsAndBranchingPointChecker.checkBPoint(point.getX(), point.getY());
    }

    @Override
    public boolean checkCPoint(Point point) {
        return LoopsAndBranchingPointChecker.checkCPoint(point.getX(), point.getY());
    }

    @Override
    public String checkPointDistanceFromOrigin(Point firstPoint, Point secondPoint) {
        return LoopsAndBranchingPointChecker
                .checkDistanceFromOrigin(firstPoint, secondPoint);
    }
}
