package by.lashkevich.jwd.service.impl;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.linearprogramutil.checker.PointCoordinatesChecker;
import by.lashkevich.jwd.service.PointService;

public class LinearProgramPointService implements PointService {
    @Override
    public boolean checkAPoint(Point point) {
        return PointCoordinatesChecker.checkAPoint(point.getX(), point.getY());
    }

    @Override
    public boolean checkBPoint(Point point) {
        return PointCoordinatesChecker.checkBPoint(point.getX(), point.getY());
    }

    @Override
    public boolean checkCPoint(Point point) {
        return PointCoordinatesChecker.checkCPoint(point.getX(), point.getY());
    }
}
