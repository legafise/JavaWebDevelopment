package by.lashkevich.lb.exception;

public class LoopsAndBranchingServiceException extends Exception {
    public LoopsAndBranchingServiceException() {
        super();
    }

    public LoopsAndBranchingServiceException(String message) {
        super(message);
    }

    public LoopsAndBranchingServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoopsAndBranchingServiceException(Throwable cause) {
        super(cause);
    }

    protected LoopsAndBranchingServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
