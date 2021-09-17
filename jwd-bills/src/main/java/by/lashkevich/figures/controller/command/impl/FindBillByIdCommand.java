package by.lashkevich.figures.controller.command.impl;

import by.lashkevich.figures.controller.command.Command;
import by.lashkevich.figures.controller.command.CommandException;
import by.lashkevich.figures.controller.command.reporter.BillReporter;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.controller.request.RequestConstant;
import by.lashkevich.figures.entity.Bill;
import by.lashkevich.figures.service.ServiceException;
import by.lashkevich.figures.service.ServiceFactory;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.impl.ViewType;

/**
 * @author Roman Lashkevich
 * @see Command
 */
public class FindBillByIdCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            BillReporter billReporter = new BillReporter();
            String billId = (String) request.getParameter(RequestConstant.DATA_NAME);
            Bill bill = ServiceFactory.getInstance().getBillService().findBillById(billId);
            billReporter.reportBillInfo(bill);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
