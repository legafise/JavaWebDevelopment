package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.constant.LinearProgramConstant;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import by.lashkevich.jwd.exception.LinearProgramTransformerException;
import by.lashkevich.jwd.reporter.RingCalculatorReporter;
import by.lashkevich.jwd.service.RingService;
import by.lashkevich.jwd.service.impl.LinearProgramRingService;
import by.lashkevich.jwd.view.impl.LinearProgramMainView;
import by.lashkevich.jwd.view.View;

import java.util.List;

import static by.lashkevich.jwd.linearprogramutil.transformer.LinearProgramTransformer.transformStringsToDoubles;

public class RingCalculatorCommand implements Command {
    private RingService ringService;

    public RingCalculatorCommand() {
        this.ringService = new LinearProgramRingService();
    }

    @Override
    public View execute(Request request) throws LinearProgramCommandException {
        try {
            List<Double> radii = transformStringsToDoubles((List<String>) request
                    .getParameter(LinearProgramConstant.DATA_NAME));
            Ring ring = createRing(radii);
            double ringArea = ringService.calculateArea(ring);
            RingCalculatorReporter.reportRingInfo(ring);
            RingCalculatorReporter.reportRingArea(ringArea);
            return new LinearProgramMainView();
        } catch (LinearProgramServiceException | LinearProgramTransformerException e) {
            throw new LinearProgramCommandException(e);
        }
    }

    private Ring createRing(List<Double> radii) {
        return new Ring(radii.get(0), radii.get(1));
    }
}
