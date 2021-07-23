package by.lashkevich.jwd.exception;

public class LinearProgramValidatorException extends Exception {
    public LinearProgramValidatorException() {
        super();
    }

    public LinearProgramValidatorException(String message) {
        super(message);
    }

    public LinearProgramValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramValidatorException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramValidatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
