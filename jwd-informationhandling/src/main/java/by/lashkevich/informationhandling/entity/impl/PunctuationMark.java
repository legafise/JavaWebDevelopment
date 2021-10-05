package by.lashkevich.informationhandling.entity.impl;

public class PunctuationMark extends TextLeaf {
    public PunctuationMark(String text, String firstGlueSymbol, String secondGlueSymbol) {
        super(text, firstGlueSymbol, secondGlueSymbol);
    }

    public PunctuationMark(String text) {
        super(text);
    }
}
