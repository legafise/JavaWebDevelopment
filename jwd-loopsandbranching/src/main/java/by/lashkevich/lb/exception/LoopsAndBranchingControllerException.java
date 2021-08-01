package by.lashkevich.lb.exception;

public class LoopsAndBranchingControllerException extends Exception {
    public LoopsAndBranchingControllerException() {
        super();
    }

    public LoopsAndBranchingControllerException(String message) {
        super(message);
    }

    public LoopsAndBranchingControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoopsAndBranchingControllerException(Throwable cause) {
        super(cause);
    }

    protected LoopsAndBranchingControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
