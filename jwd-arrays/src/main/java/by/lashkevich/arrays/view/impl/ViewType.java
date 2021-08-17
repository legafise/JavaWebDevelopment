package by.lashkevich.arrays.view.impl;

import by.lashkevich.arrays.view.View;

public enum ViewType {
    MAIN_VIEW(new ArraysMainView()),
    MATRIX_VIEW(new ArraysMatrixView()),
    ARRAY_VIEW(new ArraysArrayView());

    private final View view;

    ViewType(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
