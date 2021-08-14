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

import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportReceivedMatricesInfo;
import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportTransposeResult;

public class MatrixTransposeCommand implements Command {
    private MatrixService matrixService;

    public MatrixTransposeCommand() {
        matrixService = new ArraysMatrixService();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            ArraysMatrix matrix = (ArraysMatrix) request.getParameter(ArraysConstant.DATA_NAME);
            ArraysMatrix result = matrixService.transposeMatrix(matrix);
            reportReceivedMatricesInfo(matrix);
            reportTransposeResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (ArraysServiceException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
