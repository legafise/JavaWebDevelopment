package by.lashkevich.multithreading.controller;

import by.lashkevich.multithreading.service.ServiceFactory;
import by.lashkevich.multithreading.service.aggregator.MatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.aggregator.QueueMainMatrixDiagonalElementAggregator;
import by.lashkevich.multithreading.service.aggregator.SetMainMatrixDiagonalElementAggregator;

public class TestInvoker {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(ServiceFactory.getInstance().getMatrixService().findMatrix());
        MatrixDiagonalElementAggregator diagonalElementEditor = new SetMainMatrixDiagonalElementAggregator(5);
        MatrixDiagonalElementAggregator secondDiagonalElementEditor = new SetMainMatrixDiagonalElementAggregator(3);
        MatrixDiagonalElementAggregator tDiagonalElementEditor = new SetMainMatrixDiagonalElementAggregator(9);
        Thread firstThread = new Thread(diagonalElementEditor);
        Thread secondThread = new Thread(secondDiagonalElementEditor);
        Thread tThread = new Thread(tDiagonalElementEditor);

        firstThread.start();
        secondThread.start();
        tThread.start();
        firstThread.join();
        secondThread.join();
        tThread.join();

        System.out.println(ServiceFactory.getInstance().getMatrixService().findMatrix());
        QueueMainMatrixDiagonalElementAggregator.resetIndexes();
    }
}