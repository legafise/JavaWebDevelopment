package by.lashkevich.multithreading.dao;

import by.lashkevich.multithreading.dao.impl.MatrixDaoImpl;
import by.lashkevich.multithreading.dao.impl.MatrixDiagonalElementAggregatorDataDaoImpl;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DaoFactory {
    private static final AtomicBoolean isInstanceCreated = new AtomicBoolean(false);
    private static final Lock instanceLock = new ReentrantLock();
    private static DaoFactory instance;
    private final MatrixDao matrixDao;
    private final MatrixDiagonalElementAggregatorDataDao matrixDiagonalElementAggregatorDao;

    public static DaoFactory getInstance() {
        if (!isInstanceCreated.get()) {
            try {
                instanceLock.lock();
                if (instance == null) {
                    instance = new DaoFactory();
                    isInstanceCreated.set(true);
                }
            } finally {
                instanceLock.unlock();
            }
        }

        return instance;
    }

    private DaoFactory() {
        matrixDao = new MatrixDaoImpl();
        matrixDiagonalElementAggregatorDao = new MatrixDiagonalElementAggregatorDataDaoImpl();
    }

    public MatrixDao getMatrixDao() {
        return matrixDao;
    }

    public MatrixDiagonalElementAggregatorDataDao getMatrixDiagonalElementAggregatorDao() {
        return matrixDiagonalElementAggregatorDao;
    }
}
