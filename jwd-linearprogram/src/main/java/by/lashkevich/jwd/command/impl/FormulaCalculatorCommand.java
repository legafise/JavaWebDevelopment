package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.constant.LinearProgramConstant;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramTransformerException;
import by.lashkevich.jwd.reporter.SquareRootFormulaReporter;
import by.lashkevich.jwd.service.FormulaCalculatorService;
import by.lashkevich.jwd.service.impl.LinearProgramFormulaCalculatorService;
import by.lashkevich.jwd.view.View;
import by.lashkevich.jwd.view.impl.LinearProgramMainView;

import java.util.List;

import static by.lashkevich.jwd.linearprogramutil.transformer.LinearProgramTransformer.transformStringsToDoubles;

public class FormulaCalculatorCommand implements Command {
    private FormulaCalculatorService formulaCalculatorService;

    public FormulaCalculatorCommand() {
        this.formulaCalculatorService = new LinearProgramFormulaCalculatorService();
    }

    @Override
    public View execute(Request request) throws LinearProgramCommandException {
        try {
            List<Double> variables = transformStringsToDoubles((List<String>) request
                    .getParameter(LinearProgramConstant.DATA_NAME));
            double result = formulaCalculatorService
                    .calculateSquareRootFormula(variables.get(0), variables.get(1), variables.get(2));
            SquareRootFormulaReporter.reportSquareRootFormulaVariablesInfo(variables);
            SquareRootFormulaReporter.reportSquareRootFormulaResult(result);
            return new LinearProgramMainView();
        } catch (LinearProgramTransformerException e) {
            throw new LinearProgramCommandException(e);
        }
    }
}
