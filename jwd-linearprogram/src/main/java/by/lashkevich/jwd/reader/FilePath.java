package by.lashkevich.jwd.reader;

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
    };

    private static final String SYMBOL_NUMBERS_TASK_INFO_FILE_PATH =
            "jwd-linearprogram/src/main/resources/info/SymbolNumbersTaskInfo.txt";
    private static final String CHECK_POINT_TASK_INFO_FILE_PATH =
            "jwd-linearprogram/src/main/resources/info/CheckPointTaskInfo.txt";
    private static final String RING_CALCULATOR_TASK_INFO_FILE_PATH =
            "jwd-linearprogram/src/main/resources/info/RingCalculatorTaskInfo.txt";
    private static final String TRIANGLE_CALCULATOR_TASK_INFO_FILE_PATH =
            "jwd-linearprogram/src/main/resources/info/TriangleCalculatorTaskInfo.txt";
    private static final String SQUARE_ROOT_FORMULA_TASK_INFO_FILE_PATH =
            "jwd-linearprogram/src/main/resources/info/SquareRootFormulaTaskInfo.txt";
    private String filePath;

    public abstract String getURL();
    }
