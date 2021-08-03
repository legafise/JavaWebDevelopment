package by.lashkevich.lb.view.impl;

import by.lashkevich.lb.view.View;

public enum ViewType {
    TRIANGLE_CALCULATOR_VIEW(new LoopsAndBranchingTriangleView()),
    RING_CALCULATOR_VIEW(new LoopsAndBranchingRingView()),
    SYMBOL_NUMBERS_FINDER_VIEW(new LoopsAndBranchingSymbolView()),
    CHECK_POINT_VIEW(new LoopsAndBranchingPointView()),
    MAIN_VIEW(new LoopsAndBranchingMainView()),
    SQUARE_ROOT_FORMULA_VIEW(new LoopsAndBranchingFormulaView());

    private View view;

    ViewType(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
