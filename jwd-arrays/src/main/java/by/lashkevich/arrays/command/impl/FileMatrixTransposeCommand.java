package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.arraysutill.parser.ArraysMatrixParser;
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

import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportReceivedMatricesInfo;
import static by.lashkevich.arrays.arraysutill.reporter.ArraysMatrixReporter.reportTransposeResult;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.arrays.command.Command
 */
public class FileMatrixTransposeCommand implements Command {
    private final MatrixService matrixService;
    private final ArraysMatrixParser matrixParser;

    public FileMatrixTransposeCommand() {
        matrixService = new ArraysMatrixService();
        matrixParser = new ArraysMatrixParser();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            List<String> matrixData = (List<String>) request.getParameter(ArraysConstant.DATA_NAME);
            ArraysMatrix matrix = matrixParser.parseOneMatrix(matrixData);
            ArraysMatrix result = matrixService.transposeMatrix(matrix);
            reportReceivedMatricesInfo(matrix);
            reportTransposeResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (
                ArraysServiceException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
