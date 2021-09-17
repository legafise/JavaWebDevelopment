package by.lashkevich.figures.view.impl;

import by.lashkevich.figures.controller.Controller;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.ViewConsoleReader;
import by.lashkevich.figures.view.locale.LocaleReader;

/**
 * Class serves as a menu for selecting
 * operation for work with clients
 *
 * @author Roman Lashkevich
 * @see by.lashkevich.figures.view.View
 * @see by.lashkevich.figures.view.locale.LocaleReader
 * @see by.lashkevich.figures.view.ViewConsoleReader
 */
public class ClientView implements View {
    private static final String CLIENT_OPERATIONS_INFO_KEY = "view.client.operation.info.message";
    private final ViewConsoleReader consoleReader;
    private final LocaleReader localeReader;


    public ClientView() {
        consoleReader = new ViewConsoleReader();
        localeReader = LocaleReader.getInstance();
    }

    @Override
    public void executeView() {
        System.out.println(localeReader.readMessageFromBundle(CLIENT_OPERATIONS_INFO_KEY));
        Request request = ClientRequestType.findRequestType(consoleReader.readRequestNumber())
                .createRequest(consoleReader, localeReader);
        Controller.getInstance().doRequest(request).executeView();
    }
}
