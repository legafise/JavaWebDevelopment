package by.lashkevich.jwd.exception;

public class TriangleCalculatorException extends Exception {
    public TriangleCalculatorException() {
        super();
    }

    public TriangleCalculatorException(String message) {
        super(message);
    }

    public TriangleCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleCalculatorException(Throwable cause) {
        super(cause);
    }

    protected TriangleCalculatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
