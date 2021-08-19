package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.arraysutill.creator.ArraysRandomDataCreator;
import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.service.MatrixService;
import by.lashkevich.arrays.service.impl.ArraysMatrixService;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;

import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportAdditionResult;
import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportReceivedMatricesInfo;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.arrays.command.Command
 */
public class RandomMatrixAdditionCommand implements Command {
    private MatrixService matrixService;

    public RandomMatrixAdditionCommand() {
        matrixService = new ArraysMatrixService();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            ArraysRandomDataCreator randomDataCreator = new ArraysRandomDataCreator();
            ArraysMatrix firstRectangularMatrix = randomDataCreator.createRectangularMatrix();
            ArraysMatrix secondRectangularMatrix = randomDataCreator.createRectangularMatrix();
            ArraysMatrix result = matrixService.addMatrices(firstRectangularMatrix, secondRectangularMatrix);
            reportReceivedMatricesInfo(firstRectangularMatrix, secondRectangularMatrix);
            reportAdditionResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ArraysServiceException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
