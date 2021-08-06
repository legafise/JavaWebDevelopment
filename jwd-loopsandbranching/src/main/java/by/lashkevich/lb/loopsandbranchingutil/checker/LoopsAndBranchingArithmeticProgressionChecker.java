package by.lashkevich.lb.loopsandbranchingutil.checker;

/**
 * Utilitarian class for checking arithmetical progression
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingArithmeticProgressionChecker {
    private LoopsAndBranchingArithmeticProgressionChecker() {
    }

    public static boolean isArithmeticProgression(long number) {
        long first = number % 10 == 0 ? 10 : number % 10;
        number /= 10;
        long second = number % 10;
        long difference = first - second;

        while (number >= 10) {
            first = number % 10 == 0 ? 10 : number % 10;
            number /= 10;
            second = number % 10;

            if (difference != (first - second)) {
                return false;
            }

            difference = first - second;
        }

        return true;
    }
}
