package by.lashkevich.jwd.exception;

public class LinearProgramServerException extends Exception {
    public LinearProgramServerException() {
        super();
    }

    public LinearProgramServerException(String message) {
        super(message);
    }

    public LinearProgramServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramServerException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
