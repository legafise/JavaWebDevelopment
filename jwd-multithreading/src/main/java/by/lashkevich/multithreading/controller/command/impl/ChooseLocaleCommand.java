package by.lashkevich.multithreading.controller.command.impl;

import by.lashkevich.multithreading.controller.command.Command;
import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.controller.request.RequestConstant;
import by.lashkevich.multithreading.view.View;
import by.lashkevich.multithreading.view.impl.ViewType;
import by.lashkevich.multithreading.view.locale.LocaleReader;

/**
 * @author Roman Lashkevich
 * @see Command
 */
public class ChooseLocaleCommand implements Command {
    @Override
    public View execute(Request request) {
        int localeNumber = (int) request.getParameter(RequestConstant.DATA_NAME);
        LocaleReader.getInstance().setLocaleNumber(localeNumber);
        return ViewType.MAIN_VIEW.getView();
    }
}
