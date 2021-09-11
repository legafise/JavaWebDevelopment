package by.lashkevich.multithreading.service.aggregate;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMainMatrixDiagonalElementAggregator implements Runnable {
    private static final Lock locker = new ReentrantLock();
    private static int i = 0;
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();
    private int finalElement;

    public LockMainMatrixDiagonalElementAggregator(int finalElement) {
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
            while (i < matrixService.findMatrix().getHorizontalSize()) {
                locker.lock();
                if (i < matrixService.findMatrix().getHorizontalSize()) {
                    matrixService.setElement(i, i, finalElement);
                    i++;
                }
                locker.unlock();
                TimeUnit.MILLISECONDS.sleep(50);
            }

            i = 0;
        } catch (InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
