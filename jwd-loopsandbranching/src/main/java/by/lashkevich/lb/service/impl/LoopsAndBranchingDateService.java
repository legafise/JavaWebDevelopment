package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.entity.LoopsAndBranchingDate;
import by.lashkevich.lb.loopsandbranchingutil.validator.LoopsAndBranchingDateValidator;
import by.lashkevich.lb.service.DateService;

public class LoopsAndBranchingDateService implements DateService {
    @Override
    public boolean validateDate(LoopsAndBranchingDate date) {
        return LoopsAndBranchingDateValidator.isValidDate(date);
    }
}
