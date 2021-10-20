package by.lashkevich.xml.controller;

import by.lashkevich.xml.controller.command.Command;
import by.lashkevich.xml.controller.command.CommandException;
import by.lashkevich.xml.controller.command.CommandFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
@MultipartConfig(location = "D:\\JavaWebDevelopment\\jwd-xml\\src\\main\\resources\\uploadedfiles")
public class XMLController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Command command = CommandFactory.getInstance().initCommand(req);
            req.getRequestDispatcher(command.execute(req)).forward(req, resp);
        } catch (CommandException | ServletException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/controller?command=error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
