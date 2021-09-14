package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregator
 */
public class SemaphoreMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final Semaphore SEMAPHORE = new Semaphore(1);
    private static int i = 0;
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public static void resetCounter() {
        i = 0;
    }

    public SemaphoreMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);

            while (i < matrixService.findMatrix().getHorizontalSize()) {
                SEMAPHORE.acquire();
                if (i < matrixService.findMatrix().getHorizontalSize()) {
                    matrixService.setElement(i, i, super.getFinalElement());
                    i++;
                }
                SEMAPHORE.release();
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
