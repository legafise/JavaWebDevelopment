package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregator
 */
public class BooleanVariableMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final AtomicBoolean isBlocked = new AtomicBoolean(false);
    private static AtomicInteger addCounter = new AtomicInteger(0);
    private static boolean isDiagonalFilled = false;
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public BooleanVariableMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    @Override
    public void run() {
        try {
            while (!isDiagonalFilled) {
                if (!isBlocked.get()) {
                    isBlocked.set(true);
                    if (addCounter.get() < matrixService.findMatrix().getHorizontalSize()) {
                        matrixService.setElement(addCounter.get(), addCounter.get(), super.getFinalElement());
                        addCounter.incrementAndGet();
                        isBlocked.set(false);
                        TimeUnit.MILLISECONDS.sleep(50);
                    } else {
                        isDiagonalFilled = true;
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static void resetCounter() {
        addCounter.set(0);
    }
}
