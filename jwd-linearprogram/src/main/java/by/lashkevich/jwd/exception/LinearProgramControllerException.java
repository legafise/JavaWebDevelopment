package by.lashkevich.jwd.exception;

public class LinearProgramControllerException extends Exception {
    public LinearProgramControllerException() {
        super();
    }

    public LinearProgramControllerException(String message) {
        super(message);
    }

    public LinearProgramControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramControllerException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
