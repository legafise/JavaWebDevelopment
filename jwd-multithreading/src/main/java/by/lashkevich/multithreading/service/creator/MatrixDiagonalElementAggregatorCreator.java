package by.lashkevich.multithreading.service.creator;

import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;

import java.util.List;

/**
 * Interface for creating aggregators from list of integers
 * @author Roman Lashkevich
 */
public interface MatrixDiagonalElementAggregatorCreator {
    List<MatrixDiagonalElementAggregator> create(List<Integer> aggregatorsData);
}
