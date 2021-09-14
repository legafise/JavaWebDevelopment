package by.lashkevich.multithreading.dao;

import java.util.List;

public interface MatrixDiagonalElementAggregatorDataDao {
    List<Integer> findMatrixDiagonalElementAggregatorsData();
    List<Integer> getThreadAmountRange();
}
