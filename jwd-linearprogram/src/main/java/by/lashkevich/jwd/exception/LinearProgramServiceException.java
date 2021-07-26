package by.lashkevich.jwd.exception;

public class LinearProgramServiceException extends Exception {
    public LinearProgramServiceException() {
        super();
    }

    public LinearProgramServiceException(String message) {
        super(message);
    }

    public LinearProgramServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramServiceException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
