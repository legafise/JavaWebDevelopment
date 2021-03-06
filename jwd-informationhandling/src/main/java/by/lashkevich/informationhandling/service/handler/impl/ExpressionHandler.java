package by.lashkevich.informationhandling.service.handler.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.Expression;
import by.lashkevich.informationhandling.service.handler.BaseHandler;

public class ExpressionHandler implements BaseHandler {
    @Override
    public TextComponent parse(String text) {
        return new Expression(text);
    }
}
