package by.lashkevich.arrays.exception;

public class RequestTypeException extends Exception {
    public RequestTypeException() {
        super();
    }

    public RequestTypeException(String message) {
        super(message);
    }

    public RequestTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestTypeException(Throwable cause) {
        super(cause);
    }

    protected RequestTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
