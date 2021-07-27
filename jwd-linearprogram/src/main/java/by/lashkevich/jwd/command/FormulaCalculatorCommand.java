package by.lashkevich.jwd.command;

import by.lashkevich.jwd.creator.DataCreatorFactory;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;
import by.lashkevich.jwd.reporter.SquareRootFormulaReporter;
import by.lashkevich.jwd.service.LinearProgramFormulaCalculatorService;

import java.util.List;

public class FormulaCalculatorCommand implements Command {
    private LinearProgramFormulaCalculatorService linearProgramFormulaCalculatorService;

    public FormulaCalculatorCommand() {
        this.linearProgramFormulaCalculatorService = new LinearProgramFormulaCalculatorService();
    }

    @Override
    public void execute() throws LinearProgramCommandException {
        try {
            List<Double> variables = DataCreatorFactory.getInstance().createDataCreator().createFormulaVariables();
            double result = linearProgramFormulaCalculatorService
                    .calculateSquareRootFormula(variables.get(0), variables.get(1), variables.get(2));
            SquareRootFormulaReporter.reportSquareRootFormulaVariablesInfo(variables);
            SquareRootFormulaReporter.reportSquareRootFormulaResult(result);
        } catch (LinearProgramDataCreatorException e) {
            throw new LinearProgramCommandException(e);
        }
    }
}