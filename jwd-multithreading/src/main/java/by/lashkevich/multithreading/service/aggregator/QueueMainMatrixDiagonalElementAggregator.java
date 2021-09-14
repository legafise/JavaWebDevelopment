package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueueMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final Lock LOCKER = new ReentrantLock();
    private static ArrayDeque<Integer> indexes = findReplaceableIndexes();
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public QueueMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    @Override
    public void run() {
        try {
            while (!indexes.isEmpty()) {
                TimeUnit.MILLISECONDS.sleep(50);
                LOCKER.lock();
                if (!indexes.isEmpty()) {
                    int index = indexes.poll();
                    matrixService.setElement(index, index, super.getFinalElement());
                }
                LOCKER.unlock();
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    private static ArrayDeque<Integer> findReplaceableIndexes() {
        ArrayDeque<Integer> replaceableIndexes = new ArrayDeque<>();
        for (int i = 0; i < ServiceFactory.getInstance().getMatrixService().findMatrix().getHorizontalSize(); i++) {
            replaceableIndexes.add(i);
        }

        return replaceableIndexes;
    }

    public static void resetIndexes() {
        indexes = findReplaceableIndexes();
    }
}