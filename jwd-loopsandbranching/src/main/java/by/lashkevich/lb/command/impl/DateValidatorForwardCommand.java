package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

public class DateValidatorForwardCommand implements Command {
    @Override
    public View execute(Request request) {
        return ViewType.DATE_VALIDATOR_VIEW.getView();
    }
}
