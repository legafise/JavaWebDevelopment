package by.lashkevich.jwd.exception;

import java.util.function.Supplier;

public class LinearProgramCommandTypeException extends Exception {
    public LinearProgramCommandTypeException() {
        super();
    }

    public LinearProgramCommandTypeException(String message) {
        super(message);
    }

    public LinearProgramCommandTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramCommandTypeException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramCommandTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
