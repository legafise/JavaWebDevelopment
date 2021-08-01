package by.lashkevich.lb.exception;

public class LoopsAndBranchingTransformerException extends Exception {
    public LoopsAndBranchingTransformerException() {
        super();
    }

    public LoopsAndBranchingTransformerException(String message) {
        super(message);
    }

    public LoopsAndBranchingTransformerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoopsAndBranchingTransformerException(Throwable cause) {
        super(cause);
    }

    protected LoopsAndBranchingTransformerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
