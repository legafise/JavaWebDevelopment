package by.lashkevich.arrays.exception;

public class ArraysDataCreatorException extends Exception {
    public ArraysDataCreatorException() {
        super();
    }

    public ArraysDataCreatorException(String message) {
        super(message);
    }

    public ArraysDataCreatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysDataCreatorException(Throwable cause) {
        super(cause);
    }

    protected ArraysDataCreatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
