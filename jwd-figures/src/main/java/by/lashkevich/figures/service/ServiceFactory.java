package by.lashkevich.figures.service;

import by.lashkevich.figures.service.impl.TetrahedronServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private TetrahedronService tetrahedronService;

    public ServiceFactory(){
        tetrahedronService = new TetrahedronServiceImpl();
    }

    public static ServiceFactory getInstance(){
        return instance;
    }

    public TetrahedronService getTetrahedronService() {
        return tetrahedronService;
    }
}
