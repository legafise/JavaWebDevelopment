package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregator
 */
public class SemaphoreMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final Semaphore SEMAPHORE = new Semaphore(1);
    private static AtomicInteger addCounter = new AtomicInteger(0);
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public SemaphoreMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);

            while (addCounter.get() < matrixService.findMatrix().getHorizontalSize()) {
                SEMAPHORE.acquire();
                if (addCounter.get() < matrixService.findMatrix().getHorizontalSize()) {
                    matrixService.setElement(addCounter.get(), addCounter.get(), super.getFinalElement());
                    addCounter.incrementAndGet();
                }
                SEMAPHORE.release();
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
