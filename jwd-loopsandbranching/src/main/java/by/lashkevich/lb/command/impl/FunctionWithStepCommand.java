package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.FunctionReporter;
import by.lashkevich.lb.service.FunctionCalculatorService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingFunctionCalculatorService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.List;

public class FunctionWithStepCommand implements Command {
    private FunctionCalculatorService functionCalculatorService;

    public FunctionWithStepCommand() {
        this.functionCalculatorService = new LoopsAndBranchingFunctionCalculatorService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Double> variables = LoopsAndBranchingTransformer.transformStringsToDoubles((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            List<Double> result = functionCalculatorService
                    .calculateFunctionWithStep(variables.get(0), variables.get(1), variables.get(2));
            FunctionReporter.reportFunctionWithStepInfo(variables);
            FunctionReporter.reportFunctionWithStepResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException | LoopsAndBranchingServiceException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }
}