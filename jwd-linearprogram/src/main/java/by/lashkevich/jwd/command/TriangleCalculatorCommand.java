package by.lashkevich.jwd.command;

import by.lashkevich.jwd.creator.DataCreatorFactory;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import by.lashkevich.jwd.reporter.TriangleCalculatorReporter;
import by.lashkevich.jwd.service.TriangleService;
import by.lashkevich.jwd.service.impl.LinearProgramTriangleService;

public class TriangleCalculatorCommand implements Command {
    private TriangleService triangleService;

    public TriangleCalculatorCommand() {
        triangleService = new LinearProgramTriangleService();
    }

    @Override
    public void execute() throws LinearProgramCommandException {
        try {
            Triangle triangle = DataCreatorFactory.getInstance().createDataCreator().createTriangle();
            double triangleArea = triangleService.calculateArea(triangle);
            double trianglePerimeter = triangleService.calculatePerimeter(triangle);
            TriangleCalculatorReporter.reportTriangleInfo(triangle);
            TriangleCalculatorReporter.reportTrianglePerimeterAndArea(trianglePerimeter, triangleArea);
        } catch (LinearProgramServiceException | LinearProgramDataCreatorException e) {
            throw new LinearProgramCommandException(e);
        }
    }
}
