package by.lashkevich.informationhandling.service.handler.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.PunctuationMark;
import by.lashkevich.informationhandling.service.handler.BaseHandler;

public class PunctuationMarkHandler implements BaseHandler {
    @Override
    public TextComponent parse(String text) {
        return new PunctuationMark(text);
    }
}
