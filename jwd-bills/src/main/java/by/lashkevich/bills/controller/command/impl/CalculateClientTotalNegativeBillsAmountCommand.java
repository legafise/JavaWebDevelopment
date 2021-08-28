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

import java.math.BigDecimal;

/**
 * @author Roman Lashkevich
 * @see Command
 */
public class CalculateClientTotalNegativeBillsAmountCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            ClientReporter clientReporter = new ClientReporter();
            String clientId = (String) request.getParameter(RequestConstant.DATA_NAME);
            BigDecimal totalNegativeAmount = ServiceFactory.getInstance().getClientService()
                    .calculateTotalClientNegativeBillsAmount(clientId);
            clientReporter.reportClientTotalNegativeBillsAmountInfo(totalNegativeAmount, clientId);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
