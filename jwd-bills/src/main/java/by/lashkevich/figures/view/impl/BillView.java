package by.lashkevich.figures.view.impl;

import by.lashkevich.figures.controller.Controller;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.ViewConsoleReader;
import by.lashkevich.figures.view.locale.LocaleReader;

/**
 * Class serves as a menu for selecting
 * operation for work with bills
 *
 * @author Roman Lashkevich
 * @see by.lashkevich.figures.view.View
 * @see by.lashkevich.figures.view.locale.LocaleReader
 * @see by.lashkevich.figures.view.ViewConsoleReader
 */
public class BillView implements View {
    private static final String BILL_OPERATIONS_INFO_KEY = "view.bills.operations.info.message";
    private final ViewConsoleReader consoleReader;
    private final LocaleReader localeReader;


    public BillView() {
        consoleReader = new ViewConsoleReader();
        localeReader = LocaleReader.getInstance();
    }

    @Override
    public void executeView() {
        System.out.println(localeReader.readMessageFromBundle(BILL_OPERATIONS_INFO_KEY));
        Request request = BillRequestType.findRequestType(consoleReader.readRequestNumber())
                .createRequest(consoleReader, localeReader);
        Controller.getInstance().doRequest(request).executeView();
    }
}
