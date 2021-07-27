package by.lashkevich.jwd.service;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.linearprogramutil.checker.PointCoordinatesChecker;

public class LinearProgramPointService {
    public boolean checkAPoint(Point point) {
        return PointCoordinatesChecker.checkAPoint(point.getX(), point.getY());
    }

    public boolean checkBPoint(Point point) {
        return PointCoordinatesChecker.checkBPoint(point.getX(), point.getY());
    }

    public boolean checkCPoint(Point point) {
        return PointCoordinatesChecker.checkCPoint(point.getX(), point.getY());
    }
}
