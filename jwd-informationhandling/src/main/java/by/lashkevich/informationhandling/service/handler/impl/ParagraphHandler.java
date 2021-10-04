package by.lashkevich.informationhandling.service.handler.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.service.handler.BaseHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements BaseHandler {
    private static final Pattern SENTENCE_PATTERN = Pattern
            .compile("[A-ZА-Я]([^.]{3}|[^?!.])*([.]{3}|[.?!])");

    @Override
    public TextComponent parse(String text) {
        SentenceHandler sentenceHandler = new SentenceHandler();
        Matcher matcher = SENTENCE_PATTERN.matcher(text);
        TextComposite sentenceComposite = new TextComposite(" ", "");
        while (matcher.find()) {
            sentenceComposite.add(sentenceHandler.parse(matcher.group()));
        }

        return sentenceComposite;
    }
}
