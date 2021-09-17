package by.lashkevich.figures.controller.command.impl;

import by.lashkevich.figures.controller.command.Command;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.controller.request.RequestConstant;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.impl.ViewType;
import by.lashkevich.figures.view.locale.LocaleReader;

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
