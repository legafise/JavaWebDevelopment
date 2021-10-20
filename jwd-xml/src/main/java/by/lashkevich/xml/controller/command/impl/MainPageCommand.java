package by.lashkevich.xml.controller.command.impl;

import by.lashkevich.xml.controller.command.Command;
import by.lashkevich.xml.controller.command.CommandException;

import javax.servlet.http.HttpServletRequest;

public class MainPageCommand implements Command {
    private static final String MAIN_PAGE_PATH = "/jsp/main_page.jsp";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return MAIN_PAGE_PATH;
    }
}
