package by.lashkevich.jwd.command;

import by.lashkevich.jwd.creator.DataCreatorFactory;
import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import by.lashkevich.jwd.reporter.RingCalculatorReporter;
import by.lashkevich.jwd.service.RingService;
import by.lashkevich.jwd.service.impl.LinearProgramRingService;

public class RingCalculatorCommand implements Command {
    private RingService ringService;

    public RingCalculatorCommand() {
        this.ringService = new LinearProgramRingService();
    }

    @Override
    public void execute() throws LinearProgramCommandException {
        try {
            Ring ring = DataCreatorFactory.getInstance().createDataCreator().createRing();
            double ringArea = ringService.calculateArea(ring);
            RingCalculatorReporter.reportRingInfo(ring);
            RingCalculatorReporter.reportRingArea(ringArea);
        } catch (LinearProgramDataCreatorException | LinearProgramServiceException e) {
            throw new LinearProgramCommandException(e);
        }
    }
}
