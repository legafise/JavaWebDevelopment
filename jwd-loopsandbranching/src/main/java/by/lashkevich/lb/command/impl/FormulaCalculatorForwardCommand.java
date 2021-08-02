package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.LoopsAndBranchingFormulaView;

public class FormulaCalculatorForwardCommand implements Command {
    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        return new LoopsAndBranchingFormulaView();
    }
}