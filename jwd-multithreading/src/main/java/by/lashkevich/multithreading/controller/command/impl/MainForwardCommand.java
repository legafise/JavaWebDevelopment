package by.lashkevich.multithreading.controller.command.impl;


import by.lashkevich.multithreading.controller.command.Command;
import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.view.View;
import by.lashkevich.multithreading.view.impl.ViewType;

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
