package by.lashkevich.multithreading.service.aggregator;

public abstract class MatrixDiagonalElementAggregator extends Thread {
    private int finalElement;

    public MatrixDiagonalElementAggregator(int finalElement) {
        this.finalElement = finalElement;
    }

    public int getFinalElement() {
        return finalElement;
    }

    public void setFinalElement(int finalElement) {
        this.finalElement = finalElement;
    }
}
