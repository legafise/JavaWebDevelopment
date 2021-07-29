package by.lashkevich.jwd.exception;

public class LinearProgramReaderException extends Exception {
    public LinearProgramReaderException() {
        super();
    }

    public LinearProgramReaderException(String message) {
        super(message);
    }

    public LinearProgramReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinearProgramReaderException(Throwable cause) {
        super(cause);
    }

    protected LinearProgramReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
