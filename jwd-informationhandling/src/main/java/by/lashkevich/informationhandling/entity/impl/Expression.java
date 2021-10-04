package by.lashkevich.informationhandling.entity.impl;

public class Expression extends TextLeaf {
    public Expression(String text, String firstGlueSymbol, String secondGlueSymbol) {
        super(text, firstGlueSymbol, secondGlueSymbol);
    }

    public Expression(String text) {
        super(text);
    }
}
