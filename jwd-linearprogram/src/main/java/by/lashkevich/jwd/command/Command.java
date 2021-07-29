package by.lashkevich.jwd.command;

import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.view.View;

public interface Command {
    View execute(Request request) throws LinearProgramCommandException;
}
