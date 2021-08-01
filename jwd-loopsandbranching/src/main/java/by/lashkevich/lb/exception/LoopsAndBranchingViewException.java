package by.lashkevich.lb.exception;

public class LoopsAndBranchingViewException extends Exception {
    public LoopsAndBranchingViewException() {
        super();
    }

    public LoopsAndBranchingViewException(String message) {
        super(message);
    }

    public LoopsAndBranchingViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoopsAndBranchingViewException(Throwable cause) {
        super(cause);
    }

    protected LoopsAndBranchingViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
