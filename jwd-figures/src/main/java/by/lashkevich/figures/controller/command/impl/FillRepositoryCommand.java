package by.lashkevich.figures.controller.command.impl;

import by.lashkevich.figures.controller.command.Command;
import by.lashkevich.figures.controller.command.CommandException;
import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.entity.Tetrahedron;
import by.lashkevich.figures.service.ServiceException;
import by.lashkevich.figures.service.ServiceFactory;
import by.lashkevich.figures.service.TetrahedronService;
import by.lashkevich.figures.view.View;
import by.lashkevich.figures.view.impl.ViewType;

import java.util.List;

public class FillRepositoryCommand implements Command {
    private static final String TETRAHEDRON_INFO_FILE_NAME = "TetrahedronInfo.txt";

    @Override
    public View execute(Request request) throws CommandException {
        try {
            TetrahedronService tetrahedronService = ServiceFactory.getInstance().getTetrahedronService();
            List<Tetrahedron> tetrahedronList = tetrahedronService.readTetrahedronData(TETRAHEDRON_INFO_FILE_NAME);
            tetrahedronList.forEach(tetrahedronService::addTetrahedron);
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
