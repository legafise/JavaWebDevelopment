package by.lashkevich.multithreading.controller.command.impl;

import by.lashkevich.multithreading.controller.command.Command;
import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.view.View;
import by.lashkevich.multithreading.view.impl.ViewType;

/**
 * @author Roman Lashkevich
 * @see Command
 */
public class MenuExitCommand implements Command {
    @Override
    public View execute(Request request) {
        System.exit(0);
        return ViewType.MAIN_VIEW.getView();
    }
}
