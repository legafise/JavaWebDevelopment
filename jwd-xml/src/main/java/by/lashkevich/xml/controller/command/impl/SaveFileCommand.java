package by.lashkevich.xml.controller.command.impl;

import by.lashkevich.xml.controller.command.Command;
import by.lashkevich.xml.controller.command.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class SaveFileCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            for (Part part : request.getParts()) {
                if (part.getName().equals("xmlFile")) {
                    InputStream inputStream = part.getInputStream();
                    InputStreamReader isr = new InputStreamReader(inputStream);
                    new BufferedReader(isr)
                            .lines()
                            .collect(Collectors.joining("\n"));
                    String fileName = part.getSubmittedFileName();
                    request.setAttribute("fileName", fileName);
                    part.write(fileName);
                }
            }

            return "/controller?command=handle_xml";
        } catch (IOException | ServletException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
