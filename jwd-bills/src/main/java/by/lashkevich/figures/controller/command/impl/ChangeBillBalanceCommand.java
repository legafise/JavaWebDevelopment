package by.lashkevich.figures.controller.command.impl;

import by.lashkevich.figures.controller.command.Command;
import by.lashkevich.figures.controller.command.CommandException;
import by.lashkevich.figures.controller.command.reporter.BillReporter;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.controller.request.RequestConstant;
import by.lashkevich.figures.service.ServiceException;
import by.lashkevich.figures.service.ServiceFactory;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.impl.ViewType;

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
