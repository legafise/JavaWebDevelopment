package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregator
 */
public class LockMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final Lock LOCKER = new ReentrantLock();
    private static int i = 0;
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public LockMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    public static void resetCounter() {
        i = 0;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);

            while (i < matrixService.findMatrix().getHorizontalSize()) {
                LOCKER.lock();
                if (i < matrixService.findMatrix().getHorizontalSize()) {
                    matrixService.setElement(i, i, super.getFinalElement());
                    i++;
                }
                LOCKER.unlock();
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
