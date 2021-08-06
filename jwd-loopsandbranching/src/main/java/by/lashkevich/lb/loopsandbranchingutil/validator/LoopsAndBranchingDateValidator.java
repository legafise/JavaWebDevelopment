package by.lashkevich.lb.loopsandbranchingutil.validator;

import by.lashkevich.lb.entity.LoopsAndBranchingDate;

/**
 * Utilitarian class for date validation
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingDateValidator {
    private LoopsAndBranchingDateValidator() {
    }

    public static boolean isValidDate(LoopsAndBranchingDate date) {
        int day = date.getDay();
        int month = date.getMonth();
        return day <= 31 && day > 0 && month <= 12 && month > 0;
    }
}
