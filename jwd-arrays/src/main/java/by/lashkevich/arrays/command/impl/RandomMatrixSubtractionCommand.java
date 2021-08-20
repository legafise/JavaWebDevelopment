package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.arraysutill.creator.ArraysRandomDataCreator;
import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.service.ArraysServiceFactory;
import by.lashkevich.arrays.service.MatrixService;
import by.lashkevich.arrays.service.impl.ArraysMatrixService;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;

import java.util.List;

import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportReceivedMatricesInfo;
import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportSubtractionResult;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.arrays.command.Command
 */
public class RandomMatrixSubtractionCommand implements Command {
    private final MatrixService matrixService;

    public RandomMatrixSubtractionCommand() {
        matrixService = ArraysServiceFactory.getInstance().getMatrixService();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            ArraysRandomDataCreator randomDataCreator = new ArraysRandomDataCreator();
            ArraysMatrix firstRectangularMatrix = randomDataCreator.createRectangularMatrix();
            ArraysMatrix secondRectangularMatrix = randomDataCreator.createRectangularMatrix();
            ArraysMatrix result = matrixService.subtractMatrices(firstRectangularMatrix, secondRectangularMatrix);
            reportReceivedMatricesInfo(firstRectangularMatrix, secondRectangularMatrix);
            reportSubtractionResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ArraysServiceException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
