package by.lashkevich.lb.command;

import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.view.View;

public interface Command {
    View execute(Request request) throws LoopsAndBranchingCommandException;
}
