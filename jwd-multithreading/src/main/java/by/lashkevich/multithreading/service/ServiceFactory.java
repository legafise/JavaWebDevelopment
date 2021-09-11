package by.lashkevich.multithreading.service;

import by.lashkevich.multithreading.service.impl.MatrixServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private MatrixService matrixService;

    private ServiceFactory() {
        matrixService = new MatrixServiceImpl();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }
}
