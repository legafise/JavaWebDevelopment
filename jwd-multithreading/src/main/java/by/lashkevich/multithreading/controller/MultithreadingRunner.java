package by.lashkevich.multithreading.controller;

import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.controller.request.RequestConstant;

public class MultithreadingRunner {
    private static final int MAIN_FORWARD_COMMAND_NUMBER = -1;

    public static void main(String[] args) {
        Request request = new Request();
        request.putParameter(RequestConstant.COMMAND_NUMBER, MAIN_FORWARD_COMMAND_NUMBER);
        Controller.getInstance().doRequest(request).executeView();
    }
}