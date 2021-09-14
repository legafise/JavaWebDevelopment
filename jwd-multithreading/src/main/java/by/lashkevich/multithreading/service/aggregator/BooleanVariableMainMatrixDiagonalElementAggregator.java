package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Roman Lashkevich
 * @see MatrixDiagonalElementAggregator
 */
public class BooleanVariableMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final AtomicBoolean isBlocked = new AtomicBoolean(false);
    private static int i = 0;
    private static boolean isDiagonalFilled = false;
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public BooleanVariableMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    public static void resetCounter() {
        i = 0;
    }

    @Override
    public void run() {
        try {
            while (!isDiagonalFilled) {
                if (!isBlocked.get()) {
                    isBlocked.set(true);
                    if (i < matrixService.findMatrix().getHorizontalSize()) {
                        matrixService.setElement(i, i, super.getFinalElement());
                        i++;
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
}
