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

public class CreateNewClientCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            ClientReporter clientReporter = new ClientReporter();
            List<String> clientData = (List<String>) request.getParameter(RequestConstant.DATA_NAME);
            long clientId = Long.parseLong(clientData.get(0));
            String clientName = clientData.get(1);
            String clientSurname = clientData.get(2);
            int clientAge = Integer.parseInt(clientData.get(3));
            boolean result = ServiceFactory.getInstance().getClientService()
                    .createClient(clientId, clientName, clientSurname, clientAge);
            clientReporter.reportClientAddingResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
