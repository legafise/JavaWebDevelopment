package by.lashkevich.lb.exception;

public class LoopsAndBranchingCommandException extends Exception {
    public LoopsAndBranchingCommandException() {
        super();
    }

    public LoopsAndBranchingCommandException(String message) {
        super(message);
    }

    public LoopsAndBranchingCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoopsAndBranchingCommandException(Throwable cause) {
        super(cause);
    }

    protected LoopsAndBranchingCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
