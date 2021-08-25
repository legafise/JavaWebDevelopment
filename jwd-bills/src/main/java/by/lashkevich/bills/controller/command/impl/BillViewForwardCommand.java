package by.lashkevich.bills.controller.command.impl;

import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.command.CommandException;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;

public class BillViewForwardCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        return ViewType.BILL_VIEW.getView();
    }
}
