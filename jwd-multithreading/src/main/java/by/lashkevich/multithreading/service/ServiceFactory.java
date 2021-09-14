package by.lashkevich.multithreading.service;

import by.lashkevich.multithreading.service.impl.MatrixDiagonalAggregatorServiceImpl;
import by.lashkevich.multithreading.service.impl.MatrixServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private MatrixService matrixService;
    private MatrixDiagonalAggregatorService matrixDiagonalAggregatorService;

    private ServiceFactory() {
        matrixService = new MatrixServiceImpl();
        matrixDiagonalAggregatorService = new MatrixDiagonalAggregatorServiceImpl();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }

    public MatrixDiagonalAggregatorService getMatrixDiagonalAggregatorServiceImpl() {
        return matrixDiagonalAggregatorService;
    }
}
