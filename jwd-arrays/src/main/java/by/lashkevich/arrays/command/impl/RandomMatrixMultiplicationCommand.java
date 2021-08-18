package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.arraysutill.creator.ArraysRandomDataCreator;
import by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter;
import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.service.MatrixService;
import by.lashkevich.arrays.service.impl.ArraysMatrixService;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;

import java.util.List;

import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.*;
import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportReceivedMatricesInfo;

public class RandomMatrixMultiplicationCommand implements Command {
    private MatrixService matrixService;

    public RandomMatrixMultiplicationCommand() {
        matrixService = new ArraysMatrixService();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            ArraysRandomDataCreator randomDataCreator = new ArraysRandomDataCreator();
            ArraysMatrix firstSquareMatrix = randomDataCreator.createSquareMatrix();
            ArraysMatrix secondSquareMatrix = randomDataCreator.createSquareMatrix();
            ArraysMatrix result = matrixService.multiplyMatrices(firstSquareMatrix, secondSquareMatrix);
            reportReceivedMatricesInfo(firstSquareMatrix, secondSquareMatrix);
            reportMultiplyResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ArraysServiceException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
