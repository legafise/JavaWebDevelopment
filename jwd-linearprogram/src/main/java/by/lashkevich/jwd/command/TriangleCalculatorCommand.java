package by.lashkevich.jwd.command;

import by.lashkevich.jwd.creator.DataCreatorFactory;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import by.lashkevich.jwd.reporter.TriangleCalculatorReporter;
import by.lashkevich.jwd.service.LinearProgramTriangleService;

public class TriangleCalculatorCommand implements Command {
    private LinearProgramTriangleService linearProgramTriangleService;

    public TriangleCalculatorCommand() {
        linearProgramTriangleService = new LinearProgramTriangleService();
    }

    @Override
    public void execute() throws LinearProgramCommandException {
        try {
            Triangle triangle = DataCreatorFactory.getInstance().createDataCreator().createTriangle();
            double triangleArea = linearProgramTriangleService.calculateArea(triangle);
            double trianglePerimeter = linearProgramTriangleService.calculatePerimeter(triangle);
            TriangleCalculatorReporter.reportTriangleInfo(triangle);
            TriangleCalculatorReporter.reportTrianglePerimeterAndArea(trianglePerimeter, triangleArea);
        } catch (LinearProgramServiceException | LinearProgramDataCreatorException e) {
            throw new LinearProgramCommandException(e);
        }
    }
}
