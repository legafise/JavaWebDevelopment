package by.lashkevich.bills.controller.command;

import by.lashkevich.bills.controller.command.reporter.ClientReporter;
import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.controller.request.RequestConstant;
import by.lashkevich.bills.service.ServiceException;
import by.lashkevich.bills.service.ServiceFactory;
import by.lashkevich.bills.view.View;
import by.lashkevich.bills.view.impl.ViewType;

public class RemoveClientByIdCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            ClientReporter clientReporter = new ClientReporter();
            long clientId = Long.parseLong((String) request.getParameter(RequestConstant.DATA_NAME));
            boolean result = ServiceFactory.getInstance().getClientService().removeClient(clientId);
            clientReporter.reportClientRemovingResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
