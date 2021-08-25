package by.lashkevich.bills.controller.command.impl;

import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;

public class ClientViewForwardCommand implements Command {
    @Override
    public View execute(Request request) {
        return ViewType.CLIENT_VIEW.getView();
    }
}
