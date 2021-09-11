package by.lashkevich.multithreading.service.aggregate;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreMainMatrixDiagonalElementAggregate implements Runnable {
    private static final Semaphore semaphore = new Semaphore(2);
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();
    private int finalElement;

    public SemaphoreMainMatrixDiagonalElementAggregate(int finalElement) {
        this.finalElement = finalElement;
    }

    public int getFinalElement() {
        return finalElement;
    }

    public void setFinalElement(int finalElement) {
        this.finalElement = finalElement;
    }


    @Override
    public void run() {
        try {
            for (int i = 0; i < matrixService.findMatrix().getHorizontalSize(); i++) {
                semaphore.acquire();
                if (matrixService.getElement(i, i) == 0) {
                    matrixService.setElement(i, i, finalElement);
                }
                semaphore.release();
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
