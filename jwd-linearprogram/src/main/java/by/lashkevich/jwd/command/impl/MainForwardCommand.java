package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.view.impl.LinearProgramMainView;
import by.lashkevich.jwd.view.View;

public class MainForwardCommand implements Command {
    @Override
    public View execute(Request request) {
        return new LinearProgramMainView();
    }
}
