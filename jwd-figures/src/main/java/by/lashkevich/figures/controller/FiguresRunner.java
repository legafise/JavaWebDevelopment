package by.lashkevich.figures.controller;

import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.controller.request.RequestConstant;

public class FiguresRunner {
    private static final int FILL_REPOSITORY_COMMAND_NUMBER = -2;

    public static void main(String[] args) {
        Request request = new Request();
        request.putParameter(RequestConstant.COMMAND_NUMBER, FILL_REPOSITORY_COMMAND_NUMBER);
        Controller.getInstance().doRequest(request).executeView();
    }
}