package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.constant.LinearProgramConstant;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import by.lashkevich.jwd.exception.LinearProgramTransformerException;
import by.lashkevich.jwd.reporter.TriangleCalculatorReporter;
import by.lashkevich.jwd.service.TriangleService;
import by.lashkevich.jwd.service.impl.LinearProgramTriangleService;
import by.lashkevich.jwd.view.impl.LinearProgramMainView;
import by.lashkevich.jwd.view.View;

import java.util.List;

import static by.lashkevich.jwd.linearprogramutil.transformer.LinearProgramTransformer.transformStringsToDoubles;

public class TriangleCalculatorCommand implements Command {
    private TriangleService triangleService;

    public TriangleCalculatorCommand() {
        triangleService = new LinearProgramTriangleService();
    }

    @Override
    public View execute(Request request) throws LinearProgramCommandException {
        try {
            List<Double> coordinates = transformStringsToDoubles((List<String>) request
                    .getParameter(LinearProgramConstant.DATA_NAME));
            Triangle triangle = createTriangleUsingPointCoordinates(coordinates);
            double triangleArea = triangleService.calculateArea(triangle);
            double trianglePerimeter = triangleService.calculatePerimeter(triangle);
            TriangleCalculatorReporter.reportTriangleInfo(triangle);
            TriangleCalculatorReporter.reportTrianglePerimeterAndArea(trianglePerimeter, triangleArea);
            return new LinearProgramMainView();
        } catch (LinearProgramServiceException | LinearProgramTransformerException e) {
            throw new LinearProgramCommandException(e);
        }
    }

    private Triangle createTriangleUsingPointCoordinates(List<Double> coordinates) {
        Point firstPoint = new Point(coordinates.get(0), coordinates.get(1));
        Point secondPoint = new Point(coordinates.get(2), coordinates.get(3));
        Point thirdPoint = new Point(coordinates.get(4), coordinates.get(5));

        return new Triangle(firstPoint, secondPoint, thirdPoint);
    }
}
