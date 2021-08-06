package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.command.Command
 */
public class TrigonometricFunctionForwardCommand implements Command {
    @Override
    public View execute(Request request) {
        return ViewType.TRIGONOMETRIC_FUNCTION_VIEW.getView();
    }
}
