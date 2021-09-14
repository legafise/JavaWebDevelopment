package by.lashkevich.multithreading.service.impl;

import by.lashkevich.multithreading.dao.DaoFactory;
import by.lashkevich.multithreading.service.MatrixDiagonalAggregatorService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.creator.MatrixDiagonalElementAggregatorCreatorType;
import by.lashkevich.multithreading.service.validator.AggregatorServiceValidator;

import java.util.List;

public class MatrixDiagonalAggregatorServiceImpl implements MatrixDiagonalAggregatorService {
    private static final String INCORRECT_THREADS_RANGE_MESSAGE = "Thread amount out of range";
    private AggregatorServiceValidator aggregatorServiceValidator;

    public MatrixDiagonalAggregatorServiceImpl() {
        aggregatorServiceValidator = new AggregatorServiceValidator();
    }

    @Override
    public List<MatrixDiagonalElementAggregator> createAggregators(int aggregatorTypeNumber) {
        validateAggregatorsAmount();
        return MatrixDiagonalElementAggregatorCreatorType.findAggregatorCreator(aggregatorTypeNumber)
                .create(DaoFactory.getInstance().getMatrixDiagonalElementAggregatorDao()
                        .findMatrixDiagonalElementAggregatorsData());
    }

    private void validateAggregatorsAmount() {
        List<Integer> threadAmountRange = DaoFactory.getInstance()
                .getMatrixDiagonalElementAggregatorDao().getThreadAmountRange();
        int minAmount = threadAmountRange.get(0);
        int maxAmount = threadAmountRange.get(1);
        if (!aggregatorServiceValidator.isValidAggregatorsAmount(DaoFactory.getInstance()
                .getMatrixDiagonalElementAggregatorDao()
                .findMatrixDiagonalElementAggregatorsData(), minAmount, maxAmount)) {
            throw new ServiceException(INCORRECT_THREADS_RANGE_MESSAGE);
        }
    }
}
