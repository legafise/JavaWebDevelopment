package by.lashkevich.arrays.exception;

public class ArraysServiceException extends Exception {
    public ArraysServiceException() {
        super();
    }

    public ArraysServiceException(String message) {
        super(message);
    }

    public ArraysServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysServiceException(Throwable cause) {
        super(cause);
    }

    protected ArraysServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
