package by.lashkevich.multithreading.view.impl;

import by.lashkevich.multithreading.controller.Controller;
import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.view.View;
import by.lashkevich.multithreading.view.ViewConsoleReader;
import by.lashkevich.multithreading.view.locale.LocaleReader;

public class MatrixView implements View {
    private static final String MATRIX_OPERATIONS_INFO_KEY = "view.matrix.operation.info.message";
    private final ViewConsoleReader consoleReader;
    private final LocaleReader localeReader;

    public MatrixView() {
        consoleReader = new ViewConsoleReader();
        localeReader = LocaleReader.getInstance();
    }

    @Override
    public void executeView() {
        System.out.println(localeReader.readMessageFromBundle(MATRIX_OPERATIONS_INFO_KEY));
        Request request = MatrixRequestType
                .findRequestType(consoleReader.readRequestNumber()).createRequest(localeReader);
        Controller.getInstance().doRequest(request).executeView();
    }
}
