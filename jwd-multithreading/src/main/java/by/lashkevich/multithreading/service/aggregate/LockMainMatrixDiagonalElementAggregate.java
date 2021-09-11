package by.lashkevich.multithreading.service.aggregate;

import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.ServiceFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMainMatrixDiagonalElementAggregate implements Runnable {
    private static final Lock locker = new ReentrantLock();
    private final MatrixService matrixService = ServiceFactory.getInstance().getMatrixService();
    private int finalElement;

    public LockMainMatrixDiagonalElementAggregate(int finalElement) {
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
                locker.lock();
                if (matrixService.getElement(i, i) == 0) {
                    matrixService.setElement(i, i, finalElement);
                }
                locker.unlock();
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            locker.unlock();
            throw new ServiceException(e.getMessage());
        }
    }
}
