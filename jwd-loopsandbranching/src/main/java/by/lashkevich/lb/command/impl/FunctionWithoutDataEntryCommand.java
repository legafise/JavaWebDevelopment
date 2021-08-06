package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.reporter.FunctionReporter;
import by.lashkevich.lb.service.FunctionCalculatorService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingFunctionCalculatorService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.Map;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.command.Command
 */
public class FunctionWithoutDataEntryCommand implements Command {
    private FunctionCalculatorService functionCalculatorService;

    public FunctionWithoutDataEntryCommand() {
        this.functionCalculatorService = new LoopsAndBranchingFunctionCalculatorService();
    }

    @Override
    public View execute(Request request) {
        Map<Double, Double> result = functionCalculatorService.calculateFunctionWithoutDataEntry();
        FunctionReporter.reportFunctionWithoutDataEntryInfo();
        FunctionReporter.reportTableFunctionResult(result);
        return ViewType.MAIN_VIEW.getView();
    }
}
