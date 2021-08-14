package by.lashkevich.arrays.exception;

public class ArraysReaderException extends Exception {
    public ArraysReaderException() {
        super();
    }

    public ArraysReaderException(String message) {
        super(message);
    }

    public ArraysReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysReaderException(Throwable cause) {
        super(cause);
    }

    protected ArraysReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
