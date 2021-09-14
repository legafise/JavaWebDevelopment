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
    private static int addCounter = 0;
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
                    if (addCounter < matrixService.findMatrix().getHorizontalSize()) {
                        matrixService.setElement(addCounter, addCounter, super.getFinalElement());
                        addCounter++;
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
        addCounter = 0;
    }
}
