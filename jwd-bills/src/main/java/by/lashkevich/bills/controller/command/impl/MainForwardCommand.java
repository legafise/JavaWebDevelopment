package by.lashkevich.bills.controller.command.impl;


import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;

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
