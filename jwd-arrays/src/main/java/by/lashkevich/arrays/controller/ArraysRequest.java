package by.lashkevich.arrays.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Sheath for Map
 * @author Roman Lashkevich
 * @see Map
 */
public class ArraysRequest {
    private Map<String, Object> parameters;

    public ArraysRequest() {
        parameters = new HashMap<>();
    }

    public ArraysRequest(Map<String, Object> parameters) {
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
