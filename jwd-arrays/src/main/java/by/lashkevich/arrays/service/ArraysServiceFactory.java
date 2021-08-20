package by.lashkevich.arrays.service;

import by.lashkevich.arrays.service.impl.ArraysArrayService;
import by.lashkevich.arrays.service.impl.ArraysMatrixService;

public class ArraysServiceFactory {
    private static final ArraysServiceFactory instance = new ArraysServiceFactory();
    private final ArrayService arrayService;
    private final MatrixService matrixService;

    private ArraysServiceFactory(){
        arrayService = new ArraysArrayService();
        matrixService = new ArraysMatrixService();
    }

    public static ArraysServiceFactory getInstance(){
        return instance;
    }
    public ArrayService getArrayService(){
        return arrayService;
    }
    public MatrixService getMatrixService(){
        return matrixService;
    }
}
