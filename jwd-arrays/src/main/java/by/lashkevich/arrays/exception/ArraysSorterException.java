package by.lashkevich.arrays.exception;

public class ArraysSorterException extends Exception {
    public ArraysSorterException() {
        super();
    }

    public ArraysSorterException(String message) {
        super(message);
    }

    public ArraysSorterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysSorterException(Throwable cause) {
        super(cause);
    }

    protected ArraysSorterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
