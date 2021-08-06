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

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.command.Command
 */
public class PointOnAreaCommand implements Command {
    private PointService pointService;

    public PointOnAreaCommand() {
        pointService = new LoopsAndBranchingPointService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Double> pointCoordinates = LoopsAndBranchingTransformer.transformStringsToDoubles((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            Point point = createPoint(pointCoordinates);
            boolean aPointCheckResult = pointService.checkAPoint(point);
            boolean bPointCheckResult = pointService.checkBPoint(point);
            boolean cPointCheckResult = pointService.checkCPoint(point);
            PointCheckerReporter.reportPointInfo(Arrays.asList(point));
            PointCheckerReporter.reportPointsOnAreaCheckingResult(aPointCheckResult, bPointCheckResult, cPointCheckResult);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }

    private Point createPoint(List<Double> coordinates) {
        return new Point(coordinates.get(0), coordinates.get(1));
    }
}
