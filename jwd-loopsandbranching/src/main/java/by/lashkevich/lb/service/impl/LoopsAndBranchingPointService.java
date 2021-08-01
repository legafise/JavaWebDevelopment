package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.entity.Point;
import by.lashkevich.lb.loopsandbranchingutil.checker.LoopsAndBranchingPointCoordinatesChecker;
import by.lashkevich.lb.service.PointService;

public class LoopsAndBranchingPointService implements PointService {
    @Override
    public boolean checkAPoint(Point point) {
        return LoopsAndBranchingPointCoordinatesChecker.checkAPoint(point.getX(), point.getY());
    }

    @Override
    public boolean checkBPoint(Point point) {
        return LoopsAndBranchingPointCoordinatesChecker.checkBPoint(point.getX(), point.getY());
    }

    @Override
    public boolean checkCPoint(Point point) {
        return LoopsAndBranchingPointCoordinatesChecker.checkCPoint(point.getX(), point.getY());
    }
}
