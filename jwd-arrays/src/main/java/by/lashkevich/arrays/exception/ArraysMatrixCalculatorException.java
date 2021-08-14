package by.lashkevich.arrays.exception;

public class ArraysMatrixCalculatorException extends Exception {
    public ArraysMatrixCalculatorException() {
        super();
    }

    public ArraysMatrixCalculatorException(String message) {
        super(message);
    }

    public ArraysMatrixCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysMatrixCalculatorException(Throwable cause) {
        super(cause);
    }

    protected ArraysMatrixCalculatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
