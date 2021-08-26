package by.lashkevich.bills.view.impl;

import by.lashkevich.bills.controller.Controller;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.controller.request.RequestConstant;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.ViewConsoleReader;
import by.lashkevich.bills.view.locale.LocaleReader;

/**
 * Class serves as a menu for selecting a task
 * @author Roman Lashkevich
 * @see by.lashkevich.bills.view.View
 * @see by.lashkevich.bills.view.locale.LocaleReader
 * @see by.lashkevich.bills.view.ViewConsoleReader
 */
public class MainView implements View {
    private static final String NEW_LINE_BREAK = "\n";
    private static final String SELECT_LANGUAGE_MESSAGE = "view.select.language.message";
    private static final String SELECT_TASK_MESSAGE_KEY = "view.select.task.message";
    private static final String WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY = "view.wrong.menu.item.selected.message";
    private static final String ENTER_ZERO_TO_END_PROGRAM_MESSAGE_KEY = "view.end.program.message";
    private static final String THE_FIRST_TASK_INFORMATION_KEY = "view.first.task.info.message";
    private static final String THE_SECOND_TASK_INFORMATION_KEY = "view.second.task.info.message";
    private static final String THE_THIRD_TASK_INFORMATION_KEY = "view.third.task.info.message";
    private static final String THE_FOURTH_TASK_INFORMATION_KEY = "view.fourth.task.info.message";
    private static final int MAIN_VIEW_COMMAND_NUMBER = -1;
    private static final int CHOSE_LOCALE_COMMAND_NUMBER = 1;
    private final ViewConsoleReader consoleReader;
    private final LocaleReader localeReader;
    private final Request request;
    private boolean isChosenLocale = false;

    public MainView() {
        request = new Request();consoleReader = new ViewConsoleReader();
        localeReader = LocaleReader.getInstance();
    }

    @Override
    public void executeView() {
        if (!isChosenLocale) {
            chooseLocale();
        }

        if (!chooseTask()) {
            System.out.println(localeReader.readMessageFromBundle(WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY));
            request.putParameter(RequestConstant.COMMAND_NUMBER, MAIN_VIEW_COMMAND_NUMBER);
        }

        Controller.getInstance().doRequest(request).executeView();
    }

    private boolean chooseTask() {
        System.out.println(localeReader.readMessageFromBundle(ENTER_ZERO_TO_END_PROGRAM_MESSAGE_KEY)
                + NEW_LINE_BREAK
                + localeReader.readMessageFromBundle(SELECT_TASK_MESSAGE_KEY)
                + NEW_LINE_BREAK
                + localeReader.readMessageFromBundle(THE_FIRST_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + localeReader.readMessageFromBundle(THE_SECOND_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + localeReader.readMessageFromBundle(THE_THIRD_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + localeReader.readMessageFromBundle(THE_FOURTH_TASK_INFORMATION_KEY));
        int commandNumber = consoleReader.readCommandNumber();
        if (commandNumber == 1) {
            chooseLocale();
        }

        boolean isValidCommandNumber = commandNumber > -1 && commandNumber < 5;
        if (isValidCommandNumber) {
            request.putParameter(RequestConstant.COMMAND_NUMBER, commandNumber);
        }

        return isValidCommandNumber;
    }

    private void chooseLocale() {
        Request request = new Request();
        System.out.println(localeReader.readMessageFromBundle(SELECT_LANGUAGE_MESSAGE));
        int localeNumber = consoleReader.readLocaleNumber();
        request.putParameter(RequestConstant.COMMAND_NUMBER, CHOSE_LOCALE_COMMAND_NUMBER);
        request.putParameter(RequestConstant.DATA_NAME, localeNumber);
        isChosenLocale = true;
        Controller.getInstance().doRequest(request).executeView();
    }
}
