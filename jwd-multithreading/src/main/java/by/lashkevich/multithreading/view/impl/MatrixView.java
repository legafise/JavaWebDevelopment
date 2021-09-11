package by.lashkevich.multithreading.view.impl;

import by.lashkevich.multithreading.controller.Controller;
import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.controller.request.RequestConstant;
import by.lashkevich.multithreading.view.View;
import by.lashkevich.multithreading.view.ViewConsoleReader;
import by.lashkevich.multithreading.view.locale.LocaleReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixView implements View {
    private static final String SELECT_DATA_ENTRY_TYPE_MESSAGE_KEY = "view.select.creator.message";
    private static final String WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY = "view.wrong.menu.item.selected.message";
    private static final String MATRIX_OPERATIONS_INFO_KEY = "view.matrix.operation.info.message";
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final int MATRIX_VIEW_COMMAND_NUMBER = 1;
    private final ViewConsoleReader consoleReader;
    private final LocaleReader localeReader;

    public MatrixView() {
        consoleReader = new ViewConsoleReader();
        localeReader = LocaleReader.getInstance();
    }

    @Override
    public void executeView() {
        Request request = new Request();

//        try {
            System.out.println(localeReader.readMessageFromBundle(MATRIX_OPERATIONS_INFO_KEY));
            request = MatrixRequestType
                    .findRequestType(consoleReader.readRequestNumber()).createRequest(consoleReader, localeReader);
            Controller.getInstance().doRequest(request).executeView();
//        } catch (ViewException e) {
//            LOGGER.log(Level.ERROR, e.getMessage());
//            request.putParameter(RequestConstant.COMMAND_NUMBER, MATRIX_VIEW_COMMAND_NUMBER);
//            Controller.getInstance().doRequest(request).executeView();
//        }
    }
}
