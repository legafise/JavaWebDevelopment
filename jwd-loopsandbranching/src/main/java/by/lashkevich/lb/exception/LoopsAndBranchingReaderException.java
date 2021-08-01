package by.lashkevich.lb.exception;

public class LoopsAndBranchingReaderException extends Exception {
    public LoopsAndBranchingReaderException() {
        super();
    }

    public LoopsAndBranchingReaderException(String message) {
        super(message);
    }

    public LoopsAndBranchingReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoopsAndBranchingReaderException(Throwable cause) {
        super(cause);
    }

    protected LoopsAndBranchingReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
