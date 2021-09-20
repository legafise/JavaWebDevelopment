package by.lashkevich.figures.controller.command.impl;

import by.lashkevich.figures.controller.command.Command;
import by.lashkevich.figures.controller.command.CommandException;
import by.lashkevich.figures.controller.command.reporter.TetrahedronReporter;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.service.ServiceException;
import by.lashkevich.figures.service.ServiceFactory;
import by.lashkevich.figures.service.TetrahedronService;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.impl.ViewType;

public class FindTetrahedronsInfoCommand implements Command {
    @Override
    public View execute(Request request) throws CommandException {
        try {
            TetrahedronReporter tetrahedronReporter = new TetrahedronReporter();
            TetrahedronService tetrahedronService = new ServiceFactory().getTetrahedronService();
            tetrahedronReporter.reportTetrahedronsInfo(tetrahedronService.findAllTetrahedrons());
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
