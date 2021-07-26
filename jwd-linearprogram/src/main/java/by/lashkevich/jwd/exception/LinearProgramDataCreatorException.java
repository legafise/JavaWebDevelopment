package by.lashkevich.jwd.exception;

public class LinearProgramDataCreatorException extends Exception {
    public LinearProgramDataCreatorException() {
        super();
    }

    public LinearProgramDataCreatorException(String message) {
        super(message);
    }

    public LinearProgramDataCreatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramDataCreatorException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramDataCreatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
