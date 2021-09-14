package by.lashkevich.multithreading.controller.command.impl;

import by.lashkevich.multithreading.controller.command.Command;
import by.lashkevich.multithreading.controller.command.CommandException;
import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.view.View;
import by.lashkevich.multithreading.view.impl.ViewType;

public class MatrixViewForwardCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        return ViewType.MATRIX_VIEW.getView();
    }
}
