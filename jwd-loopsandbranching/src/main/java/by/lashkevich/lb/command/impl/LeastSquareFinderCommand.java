package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.LeastSquareFinderReporter;
import by.lashkevich.lb.service.LeastSquareFinderService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingSquaredNumberFinderService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.List;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.command.Command
 */
public class LeastSquareFinderCommand implements Command {
    private LeastSquareFinderService leastSquareFinderService;

    public LeastSquareFinderCommand() {
        this.leastSquareFinderService = new LoopsAndBranchingSquaredNumberFinderService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Double> numbers = LoopsAndBranchingTransformer.transformStringsToDoubles((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            double leastSquare = leastSquareFinderService
                    .findLeastSquaredNumber(numbers.get(0), numbers.get(1));
            LeastSquareFinderReporter.reportNumbersInfo(numbers.get(0), numbers.get(1));
            LeastSquareFinderReporter.reportLeastSquareFindingResult(leastSquare);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }
}
