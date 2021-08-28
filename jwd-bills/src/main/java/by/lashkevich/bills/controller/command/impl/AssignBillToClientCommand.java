package by.lashkevich.bills.controller.command.impl;

import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.command.CommandException;
import by.lashkevich.bills.controller.command.reporter.ClientReporter;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.controller.request.RequestConstant;
import by.lashkevich.bills.service.ServiceException;
import by.lashkevich.bills.service.ServiceFactory;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;

import java.util.List;

public class AssignBillToClientCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            ClientReporter clientReporter = new ClientReporter();
            List<String> assignBillData = (List<String>) request.getParameter(RequestConstant.DATA_NAME);
            String clientId = assignBillData.get(0);
            String billId = assignBillData.get(1);
            boolean result = ServiceFactory.getInstance().getClientService().assignBill(clientId, billId);
            clientReporter.reportClientBillAssigningResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
