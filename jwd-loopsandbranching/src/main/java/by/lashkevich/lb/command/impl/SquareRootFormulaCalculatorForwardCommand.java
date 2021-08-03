package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

public class SquareRootFormulaCalculatorForwardCommand implements Command {
    @Override
    public View execute(Request request) {
        return ViewType.SQUARE_ROOT_FORMULA_VIEW.getView();
    }
}
