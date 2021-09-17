package by.lashkevich.figures.controller.command.impl;

import by.lashkevich.figures.controller.command.Command;
import by.lashkevich.figures.controller.command.CommandException;
import by.lashkevich.figures.controller.command.reporter.BankReporter;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.service.ServiceException;
import by.lashkevich.figures.service.ServiceFactory;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.impl.ViewType;

public class SaveDataCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            BankReporter bankReporter = new BankReporter();
            ServiceFactory.getInstance().getBankService().saveBankData();
            bankReporter.saveDataResult();
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
