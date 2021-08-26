package by.lashkevich.bills.controller.command.impl;

import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.command.CommandException;
import by.lashkevich.bills.controller.command.reporter.BillReporter;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.controller.request.RequestConstant;
import by.lashkevich.bills.service.ServiceException;
import by.lashkevich.bills.service.ServiceFactory;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;

public class UnblockBillByIdCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            BillReporter billReporter = new BillReporter();
            String billId = (String) request.getParameter(RequestConstant.DATA_NAME);
            boolean result = ServiceFactory.getInstance().getBillService().unblockBillById(billId);
            billReporter.reportBillUnblockingResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}