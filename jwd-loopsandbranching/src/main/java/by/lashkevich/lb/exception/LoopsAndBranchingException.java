package by.lashkevich.lb.exception;

public class LoopsAndBranchingException extends Exception {
    public LoopsAndBranchingException() {
        super();
    }

    public LoopsAndBranchingException(String message) {
        super(message);
    }

    public LoopsAndBranchingException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoopsAndBranchingException(Throwable cause) {
        super(cause);
    }

    protected LoopsAndBranchingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
