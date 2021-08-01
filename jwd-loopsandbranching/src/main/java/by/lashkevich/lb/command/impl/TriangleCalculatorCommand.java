package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.entity.Point;
import by.lashkevich.lb.entity.Triangle;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.reporter.TriangleCalculatorReporter;
import by.lashkevich.lb.service.TriangleService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingTriangleService;
import by.lashkevich.lb.view.impl.LoopsAndBranchingMainView;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;

import java.util.List;

public class TriangleCalculatorCommand implements Command {
    private TriangleService triangleService;

    public TriangleCalculatorCommand() {
        triangleService = new LoopsAndBranchingTriangleService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Double> coordinates = LoopsAndBranchingTransformer.transformStringsToDoubles((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            Triangle triangle = createTriangleUsingPointCoordinates(coordinates);
            double triangleArea = triangleService.calculateArea(triangle);
            double trianglePerimeter = triangleService.calculatePerimeter(triangle);
            TriangleCalculatorReporter.reportTriangleInfo(triangle);
            TriangleCalculatorReporter.reportTrianglePerimeterAndArea(trianglePerimeter, triangleArea);
            return new LoopsAndBranchingMainView();
        } catch (LoopsAndBranchingServiceException | LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }

    private Triangle createTriangleUsingPointCoordinates(List<Double> coordinates) {
        Point firstPoint = new Point(coordinates.get(0), coordinates.get(1));
        Point secondPoint = new Point(coordinates.get(2), coordinates.get(3));
        Point thirdPoint = new Point(coordinates.get(4), coordinates.get(5));

        return new Triangle(firstPoint, secondPoint, thirdPoint);
    }
}
