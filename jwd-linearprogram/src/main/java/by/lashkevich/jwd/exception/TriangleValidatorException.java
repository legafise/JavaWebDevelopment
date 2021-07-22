package by.lashkevich.jwd.exception;

public class TriangleValidatorException extends Exception {
    public TriangleValidatorException() {
        super();
    }

    public TriangleValidatorException(String message) {
        super(message);
    }

    public TriangleValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleValidatorException(Throwable cause) {
        super(cause);
    }

    protected TriangleValidatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
