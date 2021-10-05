package by.lashkevich.informationhandling.entity.impl;

import by.lashkevich.informationhandling.entity.TextComponent;

public class Lexeme extends TextComposite {
    public Lexeme() {
    }

    public Lexeme(String firstGlueSymbol, String secondGlueSymbol) {
        super(firstGlueSymbol, secondGlueSymbol);
    }
}
