package by.lashkevich.multithreading.service.creator.impl;

import by.lashkevich.multithreading.service.aggregator.LockMainMatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.creator.MatrixDiagonalElementAggregatorCreator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregatorCreator
 */
public class LockMatrixDiagonalElementAggregatorCreator implements MatrixDiagonalElementAggregatorCreator {
    @Override
    public List<MatrixDiagonalElementAggregator> create(List<Integer> aggregatorsData) {
        return aggregatorsData.stream()
                .map(LockMainMatrixDiagonalElementAggregator::new).collect(Collectors.toList());
    }
}
