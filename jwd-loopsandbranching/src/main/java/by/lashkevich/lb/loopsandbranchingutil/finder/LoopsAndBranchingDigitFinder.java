package by.lashkevich.lb.loopsandbranchingutil.finder;

/**
 * Utilitarian class for finding digits in numbers
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingDigitFinder {
    private LoopsAndBranchingDigitFinder() {
    }

    public static int findLargestDigit(long number) {
        if (number < 0) {
            number *= -1;
        }

        int max = 0;
        while (number > 0) {
            if (number % 10 > max) max = (int) (number % 10);
            number /= 10;
        }

        return max;
    }
}
