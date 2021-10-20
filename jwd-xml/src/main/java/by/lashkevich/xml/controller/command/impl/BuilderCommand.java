package by.lashkevich.xml.controller.command.impl;

import by.lashkevich.xml.controller.command.Command;
import by.lashkevich.xml.controller.command.CommandException;
import by.lashkevich.xml.service.ServiceException;
import by.lashkevich.xml.service.builder.MedicineBuilder;
import by.lashkevich.xml.service.builder.MedicineBuilderType;

import javax.servlet.http.HttpServletRequest;

public class BuilderCommand implements Command {
    private static final String MEDICINE_LIST_ATTRIBUTE_NAME = "medicineList";
    private static final String BUILDER_NUMBER_ATTRIBUTE_NAME = "builderNumber";
    private static final String RESULT_PAGE_PATH = "/jsp/parsing_result.jsp";
    private static final String UPLOADED_FILES_PATH = "D:\\JavaWebDevelopment\\jwd-xml" +
            "\\src\\main\\resources\\uploadedfiles\\";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            MedicineBuilder medicineBuilder = MedicineBuilderType
                    .findBuilderByNumber(Integer.parseInt(request.getParameter(BUILDER_NUMBER_ATTRIBUTE_NAME)));
            medicineBuilder.buildMedicineList(UPLOADED_FILES_PATH + request.getAttribute("fileName"));
            request.setAttribute(MEDICINE_LIST_ATTRIBUTE_NAME, medicineBuilder.getMedicineList());
            return RESULT_PAGE_PATH;
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
