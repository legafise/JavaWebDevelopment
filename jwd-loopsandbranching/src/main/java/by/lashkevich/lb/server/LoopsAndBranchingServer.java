package by.lashkevich.lb.server;

import by.lashkevich.lb.controller.LoopsAndBranchingController;
import by.lashkevich.lb.controller.Request;

public class LoopsAndBranchingServer {
    private final LoopsAndBranchingController controller;

    public LoopsAndBranchingServer() {
        this.controller = new LoopsAndBranchingController();
    }

    public void handleRequest(Request request) {
        new Thread(() -> controller.doRequest(request).executeView()).start();
    }
}
