package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregator
 */
public class SetMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final Lock LOCKER = new ReentrantLock();
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();
    private static Set<Integer> indexes = findReplaceableIndexes();
    public static AtomicInteger addCounter = new AtomicInteger(0);

    public SetMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    @Override
    public void run() {
        try {
            while (addCounter.get() < matrixService.findMatrix().getHorizontalSize() - 1) {
                TimeUnit.MILLISECONDS.sleep(50);
                LOCKER.lock();
                if (!indexes.add(addCounter.get())) {
                    matrixService.setElement(addCounter.get(), addCounter.get(), super.getFinalElement());
                    indexes.remove(addCounter);
                    addCounter.incrementAndGet();
                }
                LOCKER.unlock();
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    private static Set<Integer> findReplaceableIndexes() {
        Set<Integer> replaceableIndexes = new HashSet<>();
        for (int i = 0; i < ServiceFactory.getInstance().getMatrixService().findMatrix().getHorizontalSize(); i++) {
            replaceableIndexes.add(i);
        }

        return replaceableIndexes;
    }

    public static void resetIndexes() {
        indexes = findReplaceableIndexes();
        addCounter.set(0);
    }
}