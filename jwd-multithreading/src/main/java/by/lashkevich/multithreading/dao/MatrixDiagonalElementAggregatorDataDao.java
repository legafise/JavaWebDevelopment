package by.lashkevich.multithreading.dao;

import java.util.List;

/**
 * Interface for management aggregators data
 * @author Roman Lashkevich
 */
public interface MatrixDiagonalElementAggregatorDataDao {
    List<Integer> findMatrixDiagonalElementAggregatorsData();
    List<Integer> getThreadAmountRange();
}
