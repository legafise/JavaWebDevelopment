package by.lashkevich.arrays.exception;

public class ArraysArrayException extends Exception {
    public ArraysArrayException() {
        super();
    }

    public ArraysArrayException(String message) {
        super(message);
    }

    public ArraysArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysArrayException(Throwable cause) {
        super(cause);
    }

    protected ArraysArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
