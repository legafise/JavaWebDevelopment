package by.lashkevich.lb.loopsandbranchingutil.finder;

public final class LoopsAndBranchingDigitFinder {
    private LoopsAndBranchingDigitFinder() {
    }

    public static int findLargestDigit(long number) {
        int max = 0;

        while (number > 0) {
            if (number % 10 > max) max = (int) (number % 10);
            number /= 10;
        }

        return max;
    }
}
