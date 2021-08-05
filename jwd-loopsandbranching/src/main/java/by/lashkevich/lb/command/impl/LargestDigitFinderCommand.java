package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.LargestDigitFinderReporter;
import by.lashkevich.lb.service.LargestDigitFinderService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingDigitService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.List;

public class LargestDigitFinderCommand implements Command {
    private LargestDigitFinderService largestDigitFinderService;

    public LargestDigitFinderCommand() {
        this.largestDigitFinderService = new LoopsAndBranchingDigitService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Long> numbers = LoopsAndBranchingTransformer.transformStringsToLong((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            long number = numbers.get(0);
            int largestDigit = largestDigitFinderService.findLargestDigit(number);
            LargestDigitFinderReporter.reportNumberInfo(number);
            LargestDigitFinderReporter.reportFindingResult(largestDigit);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }
}
