package by.lashkevich.lb.view.impl;

import by.lashkevich.lb.view.View;

public enum ViewType {
    TRIANGLE_CALCULATOR_VIEW(new LoopsAndBranchingTriangleView()),
    RING_CALCULATOR_VIEW(new LoopsAndBranchingRingView()),
    SYMBOL_NUMBERS_FINDER_VIEW(new LoopsAndBranchingSymbolView()),
    CHECK_POINT_VIEW(new LoopsAndBranchingPointOnAreaView()),
    MAIN_VIEW(new LoopsAndBranchingMainView()),
    TWO_CONDITION_FUNCTION_VIEW(new LoopsAndBranchingTwoConditionFunctionView()),
    SQUARE_ROOT_FORMULA_VIEW(new LoopsAndBranchingFormulaView()),
    LEAST_SQUARE_FINDER_VIEW(new LoopsAndBranchingLeastSquareFinderView()),
    POINT_DISTANCE_FROM_ORIGIN_VIEW(new LoopsAndBranchingPointDistanceFromOrigin()),
    DATE_VALIDATOR_VIEW(new LoopsAndBranchingDateValidatorView());

    private View view;

    ViewType(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
