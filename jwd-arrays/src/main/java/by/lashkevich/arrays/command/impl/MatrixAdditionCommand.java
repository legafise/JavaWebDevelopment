package by.lashkevich.arrays.command.impl;

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

import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportAdditionResult;
import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportReceivedMatricesInfo;

public class MatrixAdditionCommand implements Command {
    private MatrixService matrixService;

    public MatrixAdditionCommand() {
        matrixService = new ArraysMatrixService();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            List<ArraysMatrix> matrices = (List<ArraysMatrix>) request.getParameter(ArraysConstant.DATA_NAME);
            ArraysMatrix result = matrixService.addMatrices(matrices.get(0), matrices.get(1));
            reportReceivedMatricesInfo(matrices.get(0), matrices.get(1));
            reportAdditionResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ArraysServiceException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
