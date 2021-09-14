package by.lashkevich.multithreading.service.creator;

import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.creator.impl.LockMatrixDiagonalElementAggregatorCreator;
import by.lashkevich.multithreading.service.creator.impl.QueueMatrixDiagonalElementAggregatorCreator;
import by.lashkevich.multithreading.service.creator.impl.SemaphoreMatrixDiagonalElementAggregatorCreator;

import java.util.Arrays;

public enum MatrixDiagonalElementAggregatorCreatorType {
    LOCK_DIAGONAL_AGGREGATOR(new LockMatrixDiagonalElementAggregatorCreator(), 1),
    QUEUE_DIAGONAL_AGGREGATOR(new QueueMatrixDiagonalElementAggregatorCreator(), 2),
    SEMAPHORE_DIAGONAL_AGGREGATOR(new SemaphoreMatrixDiagonalElementAggregatorCreator(), 3);

    private static final String INVALID_CREATOR_NUMBER_MESSAGE = "Invalid creator number was chosen";
    private MatrixDiagonalElementAggregatorCreator matrixDiagonalElementAggregatorCreator;
    private int creatorNumber;

    MatrixDiagonalElementAggregatorCreatorType(MatrixDiagonalElementAggregatorCreator matrixDiagonalElementAggregatorCreator,
                                               int creatorNumber) {
        this.matrixDiagonalElementAggregatorCreator = matrixDiagonalElementAggregatorCreator;
        this.creatorNumber = creatorNumber;
    }

    public MatrixDiagonalElementAggregatorCreator getMatrixDiagonalElementAggregatorCreator() {
        return matrixDiagonalElementAggregatorCreator;
    }

    public int getCreatorNumber() {
        return creatorNumber;
    }

    public static MatrixDiagonalElementAggregatorCreator findAggregatorCreator(int number) {
        return Arrays.stream(MatrixDiagonalElementAggregatorCreatorType.values())
                .filter(aggregatorCreatorTypeNumber -> number == aggregatorCreatorTypeNumber.getCreatorNumber())
                .findAny()
                .map(MatrixDiagonalElementAggregatorCreatorType::getMatrixDiagonalElementAggregatorCreator)
                .orElseThrow(() -> new ServiceException(INVALID_CREATOR_NUMBER_MESSAGE));
    }
}
