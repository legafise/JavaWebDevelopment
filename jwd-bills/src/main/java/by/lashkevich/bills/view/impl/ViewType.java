package by.lashkevich.bills.view.impl;

import by.lashkevich.bills.view.View;

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
