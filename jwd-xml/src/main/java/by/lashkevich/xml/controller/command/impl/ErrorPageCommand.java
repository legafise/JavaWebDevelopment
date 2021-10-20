package by.lashkevich.xml.controller.command.impl;

import by.lashkevich.xml.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ErrorPageCommand implements Command {
    private static final String ERROR_PAGE_PATH = "/jsp/error_page.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        return ERROR_PAGE_PATH;
    }
}
