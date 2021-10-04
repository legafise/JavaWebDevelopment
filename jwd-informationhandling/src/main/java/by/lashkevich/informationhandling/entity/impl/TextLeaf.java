package by.lashkevich.informationhandling.entity.impl;

import by.lashkevich.informationhandling.entity.Leaf;

public class TextLeaf implements Leaf {
    private static final String STANDARD_FIRST_GLUE_SYMBOL = "";
    private static final String STANDARD_SECOND_GLUE_SYMBOL = "";
    private String text;
    private String firstGlueSymbol;
    private String secondGlueSymbol;

    public TextLeaf(String text, String firstGlueSymbol, String secondGlueSymbol) {
        this.text = text;
        this.firstGlueSymbol = firstGlueSymbol;
        this.secondGlueSymbol = secondGlueSymbol;
    }

    public TextLeaf(String text) {
        this.text = text;
        this.firstGlueSymbol = STANDARD_FIRST_GLUE_SYMBOL;
        this.secondGlueSymbol = STANDARD_SECOND_GLUE_SYMBOL;
    }

    public String getText() {
        return text;
    }

    @Override
    public String collect() {
        return firstGlueSymbol + text + secondGlueSymbol;
    }
}
