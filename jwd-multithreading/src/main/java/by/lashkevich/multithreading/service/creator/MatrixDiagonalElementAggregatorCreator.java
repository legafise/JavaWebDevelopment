package by.lashkevich.multithreading.service.creator;

import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;

import java.util.List;

public interface MatrixDiagonalElementAggregatorCreator {
    List<MatrixDiagonalElementAggregator> create(List<Integer> aggregatorsData);
}
