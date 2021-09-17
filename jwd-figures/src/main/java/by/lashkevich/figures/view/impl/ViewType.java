package by.lashkevich.figures.view.impl;

import by.lashkevich.figures.view.View;

public enum ViewType {
    MAIN_VIEW(new MainView());

    private final View view;

    ViewType(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
