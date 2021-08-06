package by.lashkevich.lb.service;

import java.util.List;

/**
 * Service that executes the logic of the access check task
 * @author Roman Lashkevich
 */
public interface AccessService {
    List<String> checkAccess(int password);
}
