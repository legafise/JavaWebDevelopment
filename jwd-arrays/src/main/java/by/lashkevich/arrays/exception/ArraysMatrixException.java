package by.lashkevich.arrays.exception;

public class ArraysMatrixException extends Exception {
    public ArraysMatrixException() {
        super();
    }

    public ArraysMatrixException(String message) {
        super(message);
    }

    public ArraysMatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysMatrixException(Throwable cause) {
        super(cause);
    }

    protected ArraysMatrixException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
