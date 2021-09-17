package by.lashkevich.figures.controller.command.impl;

import by.lashkevich.figures.controller.command.Command;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.impl.ViewType;

/**
 * @author Roman Lashkevich
 * @see Command
 */
public class MainForwardCommand implements Command {
    @Override
    public View execute(Request request) {
        return ViewType.MAIN_VIEW.getView();
    }
}
