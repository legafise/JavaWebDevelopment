package by.lashkevich.bills.controller.command.impl;

import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.command.CommandException;
import by.lashkevich.bills.controller.command.reporter.BankReporter;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.service.ServiceException;
import by.lashkevich.bills.service.ServiceFactory;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;

public class ShowBankInformationCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            BankReporter bankReporter = new BankReporter();
            bankReporter.reportBankInfo(ServiceFactory.getInstance().getBankService().findBank());
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
