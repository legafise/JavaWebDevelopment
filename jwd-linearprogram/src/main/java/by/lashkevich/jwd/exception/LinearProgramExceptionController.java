package by.lashkevich.jwd.exception;

public class LinearProgramExceptionController extends Exception {
    public LinearProgramExceptionController() {
        super();
    }

    public LinearProgramExceptionController(String message) {
        super(message);
    }

    public LinearProgramExceptionController(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramExceptionController(Throwable cause) {
        super(cause);
    }

    protected LinearProgramExceptionController(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
