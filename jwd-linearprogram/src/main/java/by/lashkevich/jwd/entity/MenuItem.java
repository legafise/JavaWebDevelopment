package by.lashkevich.jwd.entity;

import by.lashkevich.jwd.runner.FindNumberOfSymbolRunner;
import by.lashkevich.jwd.runner.PointCheckRunner;
import by.lashkevich.jwd.runner.SquareRootFormulaRunner;
import by.lashkevich.jwd.runner.TriangleCalculatorRunner;

import java.util.Arrays;

public enum MenuItem {
    MENU_EXIT_ITEM {
        @Override
        public boolean execute() {
            return false;
        }
    },
    TRIANGLE_CALCULATOR_ITEM {
        @Override
        public boolean execute() {
            TriangleCalculatorRunner.runTriangleCalculator();
            return true;
        }
    },
    POINT_CHECKER_ITEM {
        @Override
        public boolean execute() {
            PointCheckRunner.runPointChecker();
            return true;
        }
    },
    NUMBER_OF_SYMBOL_FINDER_ITEM {
        @Override
        public boolean execute() {
            FindNumberOfSymbolRunner.runNumberOfSymbolFinder();
            return true;
        }
    },
    SQUARE_ROOT_FORMULA_CALCULATOR_ITEM {
        @Override
        public boolean execute() {
            SquareRootFormulaRunner.RunSquareRootFormulaCalculation();
            return true;
        }
    },
    DEFAULT_ITEM {
        @Override
        public boolean execute() {
            System.out.println(INVALID_TASK_SELECTED_MESSAGE);
            return true;
        }
    };

    private static final String INVALID_TASK_SELECTED_MESSAGE = "Task with this number does not exist\n";

    public abstract boolean execute();

    public static MenuItem findMenuItem(int number) {
        return Arrays.stream(MenuItem.values())
                .filter(menuItem -> number == menuItem.ordinal())
                .findAny().orElse(DEFAULT_ITEM);
    }
}
