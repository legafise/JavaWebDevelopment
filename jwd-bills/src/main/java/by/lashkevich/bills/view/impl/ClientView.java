package by.lashkevich.bills.view.impl;

import by.lashkevich.bills.controller.Controller;
import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.ViewConsoleReader;
import by.lashkevich.bills.view.locale.LocaleReader;

/**
 * Class serves as a menu for selecting
 * operation for work with clients
 *
 * @author Roman Lashkevich
 * @see by.lashkevich.bills.view.View
 * @see by.lashkevich.bills.view.locale.LocaleReader
 * @see by.lashkevich.bills.view.ViewConsoleReader
 */
public class ClientView implements View {
    private static final String CLIENT_OPERATIONS_INFO_KEY = "view.client.operation.info.message";
    private ViewConsoleReader consoleReader;
    private LocaleReader localeReader;


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
