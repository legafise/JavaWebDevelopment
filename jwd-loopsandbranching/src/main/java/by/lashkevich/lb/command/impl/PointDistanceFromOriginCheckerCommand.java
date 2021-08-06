package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.entity.Point;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.PointCheckerReporter;
import by.lashkevich.lb.service.PointService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingPointService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.command.Command
 */
public class PointDistanceFromOriginCheckerCommand implements Command {
    private PointService pointService;

    public PointDistanceFromOriginCheckerCommand() {
        pointService = new LoopsAndBranchingPointService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Double> pointCoordinates = LoopsAndBranchingTransformer
                    .transformStringsToDoubles((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            List<Point> pointList = createPoints(pointCoordinates);
            String result =
                    pointService.checkPointDistanceFromOrigin(pointList.get(0), pointList.get(1));
            PointCheckerReporter.reportPointInfo(pointList);
            PointCheckerReporter.reportDistanceFromOriginCheckResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }

    private List<Point> createPoints(List<Double> coordinates) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(coordinates.get(0), coordinates.get(1)));
        points.add(new Point(coordinates.get(2), coordinates.get(3)));
        return points;
    }
}
