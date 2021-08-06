package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.LoopsAndBranchingTriangleView;
import by.lashkevich.lb.view.impl.ViewType;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.command.Command
 */
public class TriangleCalculatorForwardCommand implements Command {

    @Override
    public View execute(Request request) {
        return ViewType.TRIANGLE_CALCULATOR_VIEW.getView();
    }
}
