package by.lashkevich.informationhandling.service.handler.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.service.handler.BaseHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements BaseHandler {
    private static final String FIRST_GLUE_SYMBOL = "";
    private static final String SECOND_GLUE_SYMBOL = " ";
    private static final Pattern LEXEME_AND_EXPRESSION_PATTERN = Pattern.compile("([\\d()~&|^>><<>>>]" +
            "[\\d()~&|^>><<>>>]+)|(\\w|\\()(\\w|\\.{3}|\\s-|-|\\?!|!\\?|[!?.,:;)])*");
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("[\\d()~&|^>><<>>>][\\d()~&|^>><<>>>]+");

    @Override
    public TextComponent parse(String text) {
        Matcher lexemeAndExpressionMatcher = LEXEME_AND_EXPRESSION_PATTERN.matcher(text);
        LexemeHandler lexemeHandler = new LexemeHandler();
        ExpressionHandler expressionHandler = new ExpressionHandler();

        TextComposite sentenceComposite = new TextComposite(FIRST_GLUE_SYMBOL, SECOND_GLUE_SYMBOL);
        while (lexemeAndExpressionMatcher.find()) {
            Matcher expressionMatcher = EXPRESSION_PATTERN.matcher(lexemeAndExpressionMatcher.group());
            if (expressionMatcher.matches()) {
                sentenceComposite.add(expressionHandler.parse(lexemeAndExpressionMatcher.group()));
            } else {
                sentenceComposite.add(lexemeHandler.parse(lexemeAndExpressionMatcher.group()));
            }
        }

        return sentenceComposite;
    }
}
