package by.lashkevich.multithreading.controller.command.impl;

import by.lashkevich.multithreading.controller.command.Command;
import by.lashkevich.multithreading.controller.command.CommandException;
import by.lashkevich.multithreading.controller.command.reporter.MatrixReporter;
import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.controller.request.RequestConstant;
import by.lashkevich.multithreading.service.MatrixDiagonalAggregatorService;
import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;
import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.aggregator.QueueMainMatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.view.View;
import by.lashkevich.multithreading.view.impl.ViewType;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FillMatrixDiagonalWithQueueCommand implements Command {
    private MatrixDiagonalAggregatorService matrixDiagonalAggregatorService;
    private MatrixService matrixService;
    private MatrixReporter matrixReporter;

    public FillMatrixDiagonalWithQueueCommand() {
        matrixService = ServiceFactory.getInstance().getMatrixService();
        matrixDiagonalAggregatorService = ServiceFactory.getInstance().getMatrixDiagonalAggregatorServiceImpl();
        matrixReporter = new MatrixReporter();
    }

    @Override
    public View execute(Request request) throws CommandException {
        try {
            matrixReporter.reportMatrixInfoBeforeChange(matrixService.findMatrix());
            int matrixDiagonalAggregatorNumber = (int) request.getParameter(RequestConstant.DATA_NAME);
            List<MatrixDiagonalElementAggregator> aggregators = matrixDiagonalAggregatorService
                    .createAggregators(matrixDiagonalAggregatorNumber);
            for (int i = 0; i < aggregators.size(); i++) {
                aggregators.get(i).start();
            }
            TimeUnit.MILLISECONDS.sleep(500);

            matrixReporter.reportMatrixInfoAfterFillWithQueue(matrixService.findMatrix());
            QueueMainMatrixDiagonalElementAggregator.resetIndexes();
            matrixService.fillMainDiagonalWithZeros();
            return ViewType.MAIN_VIEW.getView();
        } catch (ServiceException | InterruptedException e) {
            throw new CommandException(e.getMessage());
        }
    }
}
