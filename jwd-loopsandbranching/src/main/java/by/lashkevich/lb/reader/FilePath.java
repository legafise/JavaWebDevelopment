package by.lashkevich.lb.reader;

public enum FilePath {
    CHECK_POINT_INFO_PATH {
        @Override
        public String getURL() {
            return CHECK_POINT_TASK_INFO_FILE_PATH;
        }
    },
    RING_CALCULATOR_INFO_PATH {
        @Override
        public String getURL() {
            return RING_CALCULATOR_TASK_INFO_FILE_PATH;
        }
    },
    SQUARE_ROOT_FORMULA_INFO_PATH {
        @Override
        public String getURL() {
            return SQUARE_ROOT_FORMULA_TASK_INFO_FILE_PATH;
        }
    },
    SYMBOL_NUMBERS_INFO_PATH {
        @Override
        public String getURL() {
            return SYMBOL_NUMBERS_TASK_INFO_FILE_PATH;
        }
    },
    TRIANGLE_CALCULATOR_INFO_PATH {
        @Override
        public String getURL() {
            return TRIANGLE_CALCULATOR_TASK_INFO_FILE_PATH;
        }
    },
    DATE_VALIDATOR_INFO_PATH {
        @Override
        public String getURL() {
            return DATE_VALIDATOR_TASK_INFO_PATH;
        }
    },
    LEAST_SQUARE_FINDER_INFO_PATH {
        @Override
        public String getURL() {
            return LEAST_SQUARE_FINDER_TASK_INFO_PATH;
        }
    },
    POINT_DISTANCE_FROM_ORIGIN_INFO_PATH {
        @Override
        public String getURL() {
            return POINT_DISTANCE_FROM_ORIGIN_TASK_INFO_PATH;
        }
    },
    TWO_CONDITION_FUNCTION_INFO_PATH {
        @Override
        public String getURL() {
            return TWO_CONDITION_FUNCTION_TASK_INFO_FILE_PATH;
        }
    };

    private static final String SYMBOL_NUMBERS_TASK_INFO_FILE_PATH =
            "jwd-loopsandbranching/src/main/resources/info/SymbolNumbersTaskInfo.txt";
    private static final String CHECK_POINT_TASK_INFO_FILE_PATH =
            "jwd-loopsandbranching/src/main/resources/info/CheckPointOnAreaTaskInfo.txt";
    private static final String RING_CALCULATOR_TASK_INFO_FILE_PATH =
            "jwd-loopsandbranching/src/main/resources/info/RingCalculatorTaskInfo.txt";
    private static final String TRIANGLE_CALCULATOR_TASK_INFO_FILE_PATH =
            "jwd-loopsandbranching/src/main/resources/info/TriangleCalculatorTaskInfo.txt";
    private static final String SQUARE_ROOT_FORMULA_TASK_INFO_FILE_PATH =
            "jwd-loopsandbranching/src/main/resources/info/SquareRootFormulaTaskInfo.txt";
    private static final String TWO_CONDITION_FUNCTION_TASK_INFO_FILE_PATH =
            "jwd-loopsandbranching/src/main/resources/info/TwoConditionFunctionTaskInfo.txt";
    private static final String DATE_VALIDATOR_TASK_INFO_PATH =
            "jwd-loopsandbranching/src/main/resources/info/DateValidatorTaskInfo.txt";
    private static final String LEAST_SQUARE_FINDER_TASK_INFO_PATH =
            "jwd-loopsandbranching/src/main/resources/info/LeastSquareFinderTaskInfo.txt";
    private static final String POINT_DISTANCE_FROM_ORIGIN_TASK_INFO_PATH =
            "jwd-loopsandbranching/src/main/resources/info/CheckPointDistanceFromOrigin.txt";

    public abstract String getURL();
}
