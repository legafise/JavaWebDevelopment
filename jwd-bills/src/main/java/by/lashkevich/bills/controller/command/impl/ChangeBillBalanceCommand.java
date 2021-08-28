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

import java.util.List;

/**
 * @author Roman Lashkevich
 * @see Command
 */
public class ChangeBillBalanceCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            BillReporter billReporter = new BillReporter();
            List<String> balanceData = (List<String>) request.getParameter(RequestConstant.DATA_NAME);
            String id = balanceData.get(0);
            String balance = balanceData.get(1);
            boolean result = ServiceFactory.getInstance().getBillService().changeBalance(id, balance);
            billReporter.reportBillBalanceChangingResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
