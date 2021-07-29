package by.lashkevich.jwd.exception;

public class LinearProgramViewException extends Exception {
    public LinearProgramViewException() {
        super();
    }

    public LinearProgramViewException(String message) {
        super(message);
    }

    public LinearProgramViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramViewException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
