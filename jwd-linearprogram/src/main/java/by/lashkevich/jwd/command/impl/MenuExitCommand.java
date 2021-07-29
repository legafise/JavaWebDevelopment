package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.view.impl.LinearProgramMainView;
import by.lashkevich.jwd.view.View;

public class MenuExitCommand implements Command {
    @Override
    public View execute(Request request) {
        System.exit(0);
        return new LinearProgramMainView();
    }
}
