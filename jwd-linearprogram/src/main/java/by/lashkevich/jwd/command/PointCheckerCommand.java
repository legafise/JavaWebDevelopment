package by.lashkevich.jwd.command;

import by.lashkevich.jwd.creator.DataCreatorFactory;
import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;
import by.lashkevich.jwd.reporter.PointCheckerReporter;
import by.lashkevich.jwd.service.LinearProgramPointService;

public class PointCheckerCommand implements Command {
    private LinearProgramPointService linearProgramPointService;

    public PointCheckerCommand() {
        linearProgramPointService = new LinearProgramPointService();
    }

    @Override
    public void execute() throws LinearProgramCommandException {
        try {
            Point point = DataCreatorFactory.getInstance().createDataCreator().pointCreator();
            boolean aPointCheckResult = linearProgramPointService.checkAPoint(point);
            boolean bPointCheckResult = linearProgramPointService.checkBPoint(point);
            boolean cPointCheckResult = linearProgramPointService.checkCPoint(point);
            PointCheckerReporter.reportPointInfo(point);
            PointCheckerReporter.reportCheckResult(aPointCheckResult, bPointCheckResult, cPointCheckResult);
        } catch (LinearProgramDataCreatorException e) {
            throw new LinearProgramCommandException(e);
        }
    }
}
