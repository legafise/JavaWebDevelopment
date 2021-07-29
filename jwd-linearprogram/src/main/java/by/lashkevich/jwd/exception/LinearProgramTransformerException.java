package by.lashkevich.jwd.exception;

public class LinearProgramTransformerException extends Exception {
    public LinearProgramTransformerException() {
        super();
    }

    public LinearProgramTransformerException(String message) {
        super(message);
    }

    public LinearProgramTransformerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramTransformerException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramTransformerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
