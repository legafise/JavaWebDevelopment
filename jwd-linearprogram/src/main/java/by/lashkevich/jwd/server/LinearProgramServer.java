package by.lashkevich.jwd.server;

import by.lashkevich.jwd.controller.LinearProgramController;
import by.lashkevich.jwd.controller.Request;

public class LinearProgramServer {
    private final LinearProgramController controller;

    public LinearProgramServer() {
        this.controller = new LinearProgramController();
    }

    public void handleRequest(Request request) {
        new Thread(() -> controller.doRequest(request).executeView()).start();
    }
}
