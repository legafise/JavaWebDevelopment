package by.lashkevich.multithreading.service.aggregator;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserMainMatrixDiagonalElementAggregator extends MatrixDiagonalElementAggregator {
    private static final Phaser PHASER = new Phaser();
    private static int i = 0;
    private static boolean isDiagonalFilled = false;
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();

    public PhaserMainMatrixDiagonalElementAggregator(int finalElement) {
        super(finalElement);
    }

    public static void resetCounter() {
        i = 0;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            while (!isDiagonalFilled) {
                if (i < matrixService.findMatrix().getHorizontalSize()) {
                    matrixService.setElement(i, i, super.getFinalElement());
                    i++;
                    TimeUnit.MILLISECONDS.sleep(50);
                } else {
                    isDiagonalFilled = true;
                }
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
