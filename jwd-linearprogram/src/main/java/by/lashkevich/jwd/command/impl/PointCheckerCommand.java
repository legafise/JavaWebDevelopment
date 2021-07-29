package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.constant.LinearProgramConstant;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramTransformerException;
import by.lashkevich.jwd.reporter.PointCheckerReporter;
import by.lashkevich.jwd.service.PointService;
import by.lashkevich.jwd.service.impl.LinearProgramPointService;
import by.lashkevich.jwd.view.View;
import by.lashkevich.jwd.view.impl.LinearProgramMainView;

import java.util.List;

import static by.lashkevich.jwd.linearprogramutil.transformer.LinearProgramTransformer.transformStringsToDoubles;

public class PointCheckerCommand implements Command {
    private PointService pointService;

    public PointCheckerCommand() {
        pointService = new LinearProgramPointService();
    }

    @Override
    public View execute(Request request) throws LinearProgramCommandException {
        try {
            List<Double> pointCoordinates = transformStringsToDoubles((List<String>) request
                    .getParameter(LinearProgramConstant.DATA_NAME));
            Point point = createPoint(pointCoordinates);
            boolean aPointCheckResult = pointService.checkAPoint(point);
            boolean bPointCheckResult = pointService.checkBPoint(point);
            boolean cPointCheckResult = pointService.checkCPoint(point);
            PointCheckerReporter.reportPointInfo(point);
            PointCheckerReporter.reportCheckResult(aPointCheckResult, bPointCheckResult, cPointCheckResult);
            return new LinearProgramMainView();
        } catch (LinearProgramTransformerException e) {
            throw new LinearProgramCommandException(e);
        }
    }

    private Point createPoint(List<Double> coordinates) {
        return new Point(coordinates.get(0), coordinates.get(1));
    }
}
