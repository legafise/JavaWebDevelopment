package by.lashkevich.arrays.exception;

public class ArraysControllerException extends Exception {
    public ArraysControllerException() {
        super();
    }

    public ArraysControllerException(String message) {
        super(message);
    }

    public ArraysControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysControllerException(Throwable cause) {
        super(cause);
    }

    protected ArraysControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
