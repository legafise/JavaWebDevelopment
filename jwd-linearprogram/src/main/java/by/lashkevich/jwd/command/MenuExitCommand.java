package by.lashkevich.jwd.command;

public class MenuExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
