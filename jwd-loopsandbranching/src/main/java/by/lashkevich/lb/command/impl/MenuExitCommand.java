package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.view.impl.LoopsAndBranchingMainView;
import by.lashkevich.lb.view.View;

public class MenuExitCommand implements Command {
    @Override
    public View execute(Request request) {
        System.exit(0);
        return new LoopsAndBranchingMainView();
    }
}