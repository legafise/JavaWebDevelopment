package by.lashkevich.jwd.command;

import by.lashkevich.jwd.exception.LinearProgramCommandException;

public interface Command {
    void execute() throws LinearProgramCommandException;
}
