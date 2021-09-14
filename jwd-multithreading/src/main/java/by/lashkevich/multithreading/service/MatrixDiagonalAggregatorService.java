package by.lashkevich.multithreading.service;

import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;

import java.util.List;

public interface MatrixDiagonalAggregatorService {
    List<MatrixDiagonalElementAggregator> createAggregators(int aggregatorTypeNumber);
}
