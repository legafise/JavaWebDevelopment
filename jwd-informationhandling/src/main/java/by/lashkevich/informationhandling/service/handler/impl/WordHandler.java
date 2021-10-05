package by.lashkevich.informationhandling.service.handler.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.entity.impl.Word;
import by.lashkevich.informationhandling.service.handler.BaseHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler implements BaseHandler {
    private static final Pattern LETTER_PATTERN = Pattern.compile("\\w");

    @Override
    public TextComponent parse(String text) {
        Matcher matcher = LETTER_PATTERN.matcher(text);
        TextComposite wordComposite = new Word();
        LetterHandler letterHandler = new LetterHandler();
        while (matcher.find()) {
            wordComposite.add(letterHandler.parse(matcher.group()));
        }

        return wordComposite;
    }
}
