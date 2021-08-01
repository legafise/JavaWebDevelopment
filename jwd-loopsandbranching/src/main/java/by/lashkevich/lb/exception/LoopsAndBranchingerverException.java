package by.lashkevich.lb.exception;

public class LoopsAndBranchingerverException extends Exception {
    public LoopsAndBranchingerverException() {
        super();
    }

    public LoopsAndBranchingerverException(String message) {
        super(message);
    }

    public LoopsAndBranchingerverException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoopsAndBranchingerverException(Throwable cause) {
        super(cause);
    }

    protected LoopsAndBranchingerverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
