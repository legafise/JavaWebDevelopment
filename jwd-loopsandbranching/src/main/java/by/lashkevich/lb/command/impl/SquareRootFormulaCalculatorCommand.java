package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.SquareRootFormulaReporter;
import by.lashkevich.lb.service.FormulaCalculatorService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingFormulaService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.List;

public class SquareRootFormulaCalculatorCommand implements Command {
    private FormulaCalculatorService formulaCalculatorService;

    public SquareRootFormulaCalculatorCommand() {
        this.formulaCalculatorService = new LoopsAndBranchingFormulaService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Double> variables = LoopsAndBranchingTransformer.transformStringsToDoubles((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            double result = formulaCalculatorService
                    .calculateSquareRootFormula(variables.get(0), variables.get(1), variables.get(2));
            SquareRootFormulaReporter.reportSquareRootFormulaVariablesInfo(variables);
            SquareRootFormulaReporter.reportSquareRootFormulaResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }
}
