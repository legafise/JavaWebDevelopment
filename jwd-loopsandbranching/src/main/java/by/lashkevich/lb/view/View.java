package by.lashkevich.lb.view;

/**
 * View layer main interface
 * @author Roman Lashkevich
 */
public interface View {
    /**
     * Method for collect information and
     * send it to the controller
     */
    void executeView();

    /**
     * Method for getting the number of the command
     * that the controller will execute
     */
    int getViewCommandNumber();
}
