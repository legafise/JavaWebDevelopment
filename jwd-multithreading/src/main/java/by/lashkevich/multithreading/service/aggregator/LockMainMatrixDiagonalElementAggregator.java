package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregator
 */
public class LockMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final Lock LOCKER = new ReentrantLock();
    private static AtomicInteger addCounter = new AtomicInteger(0);
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public LockMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);

            while (addCounter.get() < matrixService.findMatrix().getHorizontalSize()) {
                LOCKER.lock();
                if (addCounter.get() < matrixService.findMatrix().getHorizontalSize()) {
                    matrixService.setElement(addCounter.get(), addCounter.get(), super.getFinalElement());
                    addCounter.incrementAndGet();
                }
                LOCKER.unlock();
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static void resetCounter() {
        addCounter.set(0);
    }
}
