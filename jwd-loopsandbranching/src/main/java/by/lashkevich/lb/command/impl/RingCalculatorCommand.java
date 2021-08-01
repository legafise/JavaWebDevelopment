package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.entity.Ring;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.reporter.RingCalculatorReporter;
import by.lashkevich.lb.service.RingService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingRingService;
import by.lashkevich.lb.view.impl.LoopsAndBranchingMainView;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;

import java.util.List;

public class RingCalculatorCommand implements Command {
    private RingService ringService;

    public RingCalculatorCommand() {
        this.ringService = new LoopsAndBranchingRingService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Double> radii = LoopsAndBranchingTransformer.transformStringsToDoubles((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            Ring ring = createRing(radii);
            double ringArea = ringService.calculateArea(ring);
            RingCalculatorReporter.reportRingInfo(ring);
            RingCalculatorReporter.reportRingArea(ringArea);
            return new LoopsAndBranchingMainView();
        } catch (LoopsAndBranchingServiceException | LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }

    private Ring createRing(List<Double> radii) {
        return new Ring(radii.get(0), radii.get(1));
    }
}
