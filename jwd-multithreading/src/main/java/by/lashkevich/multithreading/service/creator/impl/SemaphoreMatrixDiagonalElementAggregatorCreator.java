package by.lashkevich.multithreading.service.creator.impl;

import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.aggregator.SemaphoreMainMatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.creator.MatrixDiagonalElementAggregatorCreator;

import java.util.List;
import java.util.stream.Collectors;

public class SemaphoreMatrixDiagonalElementAggregatorCreator implements MatrixDiagonalElementAggregatorCreator {
    @Override
    public List<MatrixDiagonalElementAggregator> create(List<Integer> aggregatorsData) {
        return aggregatorsData.stream()
                .map(SemaphoreMainMatrixDiagonalElementAggregator::new).collect(Collectors.toList());
    }
}
