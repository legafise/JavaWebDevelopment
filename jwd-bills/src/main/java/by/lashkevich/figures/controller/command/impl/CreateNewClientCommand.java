package by.lashkevich.figures.controller.command.impl;

import by.lashkevich.figures.controller.command.Command;
import by.lashkevich.figures.controller.command.CommandException;
import by.lashkevich.figures.controller.command.reporter.ClientReporter;
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
public class CreateNewClientCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            ClientReporter clientReporter = new ClientReporter();
            List<String> clientData = (List<String>) request.getParameter(RequestConstant.DATA_NAME);
            String clientId = clientData.get(0);
            String clientName = clientData.get(1);
            String clientSurname = clientData.get(2);
            String clientAge = clientData.get(3);
            boolean result = ServiceFactory.getInstance().getClientService()
                    .createClient(clientId, clientName, clientSurname, clientAge);
            clientReporter.reportClientAddingResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
