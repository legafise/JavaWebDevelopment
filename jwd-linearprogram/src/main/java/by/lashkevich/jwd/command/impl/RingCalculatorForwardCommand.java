package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.view.impl.LinearProgramRingView;
import by.lashkevich.jwd.view.View;

public class RingCalculatorForwardCommand implements Command {

    @Override
    public View execute(Request request) throws LinearProgramCommandException {
        return new LinearProgramRingView();
    }
}
