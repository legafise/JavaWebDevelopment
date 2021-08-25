package by.lashkevich.bills.controller.command.impl;

import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.controller.request.RequestConstant;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;
import by.lashkevich.bills.view.locale.LocaleReader;

public class ChooseLocaleCommand implements Command {
    @Override
    public View execute(Request request) {
        int localeNumber = (int) request.getParameter(RequestConstant.DATA_NAME);
        LocaleReader.getInstance().setLocaleNumber(localeNumber);
        return ViewType.MAIN_VIEW.getView();
    }
}
