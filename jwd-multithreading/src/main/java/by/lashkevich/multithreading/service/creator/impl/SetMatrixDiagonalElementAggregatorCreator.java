package by.lashkevich.multithreading.service.creator.impl;

import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.aggregator.SetMainMatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.creator.MatrixDiagonalElementAggregatorCreator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregatorCreator
 */
public class SetMatrixDiagonalElementAggregatorCreator implements MatrixDiagonalElementAggregatorCreator {
    @Override
    public List<MatrixDiagonalElementAggregator> create(List<Integer> aggregatorsData) {
        return aggregatorsData.stream()
                .map(SetMainMatrixDiagonalElementAggregator::new).collect(Collectors.toList());
    }
}
