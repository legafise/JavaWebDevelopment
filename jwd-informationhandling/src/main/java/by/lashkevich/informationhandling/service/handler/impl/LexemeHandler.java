package by.lashkevich.informationhandling.service.handler.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.Lexeme;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.service.handler.BaseHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler implements BaseHandler {
    private static final Pattern WORD_AND_PUNCTUATION_MARK_PATTERN = Pattern.compile("[\\w]+|[.,!:;?()-]");
    private static final Pattern WORD_PATTERN = Pattern.compile("[\\w]+");

    @Override
    public TextComponent parse(String text) {
        Matcher wordAndPunctuationMatcher = WORD_AND_PUNCTUATION_MARK_PATTERN.matcher(text);
        PunctuationMarkHandler punctuationHandler = new PunctuationMarkHandler();
        WordHandler wordHandler = new WordHandler();
        TextComposite lexemeComposite = new Lexeme();

        while (wordAndPunctuationMatcher.find()) {
            Matcher wordMatcher = WORD_PATTERN.matcher(wordAndPunctuationMatcher.group());
            if (wordMatcher.matches()) {
                lexemeComposite.add(wordHandler.parse(wordAndPunctuationMatcher.group()));
            } else {
                lexemeComposite.add(punctuationHandler.parse(wordAndPunctuationMatcher.group()));
            }
        }

        return lexemeComposite;
    }
}
