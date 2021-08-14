package by.lashkevich.arrays.exception;

public class ArraysCommandException extends Exception {
    public ArraysCommandException() {
        super();
    }

    public ArraysCommandException(String message) {
        super(message);
    }

    public ArraysCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysCommandException(Throwable cause) {
        super(cause);
    }

    protected ArraysCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
