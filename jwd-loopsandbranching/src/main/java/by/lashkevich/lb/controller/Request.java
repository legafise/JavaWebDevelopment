package by.lashkevich.lb.controller;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private Map<String, Object> parameters;

    public Request() {
        parameters = new HashMap<>();
    }

    public Request(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public void putParameter(String name, Object parameter) {
        parameters.put(name, parameter);
    }

    public Object getParameter(String name) {
        return parameters.get(name);
    }
}