package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

public class ArithmeticProgressionCheckerForwardCommand implements Command {
    @Override
    public View execute(Request request) {
        return ViewType.ARITHMETIC_PROGRESSION_CHECKER_VIEW.getView();
    }
}
