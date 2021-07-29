package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.view.View;
import by.lashkevich.jwd.view.impl.LinearProgramTriangleView;

public class TriangleCalculatorForwardCommand implements Command {

    @Override
    public View execute(Request request) {
        return new LinearProgramTriangleView();
    }
}
