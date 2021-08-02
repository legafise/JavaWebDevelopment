package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.entity.Point;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.reporter.PointCheckerReporter;
import by.lashkevich.lb.service.PointService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingPointService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.LoopsAndBranchingMainView;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;

import java.util.List;

public class PointCheckerCommand implements Command {
    private PointService pointService;

    public PointCheckerCommand() {
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
            PointCheckerReporter.reportPointInfo(point);
            PointCheckerReporter.reportCheckResult(aPointCheckResult, bPointCheckResult, cPointCheckResult);
            return new LoopsAndBranchingMainView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }

    private Point createPoint(List<Double> coordinates) {
        return new Point(coordinates.get(0), coordinates.get(1));
    }
}