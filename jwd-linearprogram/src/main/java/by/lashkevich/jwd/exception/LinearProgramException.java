package by.lashkevich.jwd.exception;

public class LinearProgramException extends Exception {
    public LinearProgramException() {
        super();
    }

    public LinearProgramException(String message) {
        super(message);
    }

    public LinearProgramException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
