package by.lashkevich.multithreading.service.creator.impl;

import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.aggregator.QueueMainMatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.creator.MatrixDiagonalElementAggregatorCreator;

import java.util.List;
import java.util.stream.Collectors;

public class QueueMatrixDiagonalElementAggregatorCreator implements MatrixDiagonalElementAggregatorCreator {
    @Override
    public List<MatrixDiagonalElementAggregator> create(List<Integer> aggregatorsData) {
        return aggregatorsData.stream()
                .map(QueueMainMatrixDiagonalElementAggregator::new).collect(Collectors.toList());
    }
}
