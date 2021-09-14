package by.lashkevich.multithreading.view.impl;

import by.lashkevich.multithreading.view.View;

public enum ViewType {
    MAIN_VIEW(new MainView()),
    MATRIX_VIEW(new MatrixView());

    private final View view;

    ViewType(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
