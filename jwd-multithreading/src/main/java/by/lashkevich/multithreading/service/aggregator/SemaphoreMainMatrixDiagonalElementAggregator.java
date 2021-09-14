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
    private static int addCounter = 0;
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public SemaphoreMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);

            while (addCounter < matrixService.findMatrix().getHorizontalSize()) {
                SEMAPHORE.acquire();
                if (addCounter < matrixService.findMatrix().getHorizontalSize()) {
                    matrixService.setElement(addCounter, addCounter, super.getFinalElement());
                    addCounter++;
                }
                SEMAPHORE.release();
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static void resetCounter() {
        addCounter = 0;
    }
}
