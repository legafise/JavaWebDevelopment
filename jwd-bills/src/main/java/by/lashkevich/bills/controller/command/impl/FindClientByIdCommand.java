package by.lashkevich.bills.controller.command.impl;

import by.lashkevich.bills.controller.command.Command;
import by.lashkevich.bills.controller.command.CommandException;
import by.lashkevich.bills.controller.command.reporter.ClientReporter;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.controller.request.RequestConstant;
import by.lashkevich.bills.entity.Client;
import by.lashkevich.bills.service.ServiceException;
import by.lashkevich.bills.service.ServiceFactory;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;

/**
 * @author Roman Lashkevich
 * @see Command
 */
public class FindClientByIdCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            ClientReporter clientReporter = new ClientReporter();
            String clientId = (String) request.getParameter(RequestConstant.DATA_NAME);
            Client client = ServiceFactory.getInstance().getClientService().findClientById(clientId);
            clientReporter.reportClientInfo(client);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
