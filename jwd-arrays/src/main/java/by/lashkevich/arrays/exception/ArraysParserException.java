package by.lashkevich.arrays.exception;

public class ArraysParserException extends Exception {
    public ArraysParserException() {
        super();
    }

    public ArraysParserException(String message) {
        super(message);
    }

    public ArraysParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysParserException(Throwable cause) {
        super(cause);
    }

    protected ArraysParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
