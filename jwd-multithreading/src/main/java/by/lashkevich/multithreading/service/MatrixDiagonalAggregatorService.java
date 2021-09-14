package by.lashkevich.multithreading.service;

import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;

import java.util.List;

/**
 * Interface that performs actions on aggregators
 * @author Roman Lashkevich
 */
public interface MatrixDiagonalAggregatorService {
    List<MatrixDiagonalElementAggregator> createAggregators(int aggregatorTypeNumber);
}
