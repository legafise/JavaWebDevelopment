package by.lashkevich.lb.service;

import by.lashkevich.lb.entity.LoopsAndBranchingDate;

/**
 * Service that executes the logic of the date validation task
 * @author Roman Lashkevich
 */
public interface DateService {
    boolean validateDate(LoopsAndBranchingDate date);
}
