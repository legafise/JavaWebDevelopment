package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.ArithmeticProgressionReporter;
import by.lashkevich.lb.service.ArithmeticProgressionService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingArithmeticProgressionService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.List;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.command.Command
 */
public class ArithmeticProgressionCheckerCommand implements Command {
    private ArithmeticProgressionService arithmeticProgressionService;

    public ArithmeticProgressionCheckerCommand() {
        this.arithmeticProgressionService = new LoopsAndBranchingArithmeticProgressionService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Long> numbers = LoopsAndBranchingTransformer.transformStringsToLong((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            long number = numbers.get(0);
            boolean isProgression = arithmeticProgressionService.checkArithmeticProgression(number);
            ArithmeticProgressionReporter.reportNumberInfo(number);
            ArithmeticProgressionReporter.reportCheckingResult(isProgression);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }
}
