package by.lashkevich.jwd.exception;

public class LinearProgramCommandException extends Exception {
    public LinearProgramCommandException() {
        super();
    }

    public LinearProgramCommandException(String message) {
        super(message);
    }

    public LinearProgramCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramCommandException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
