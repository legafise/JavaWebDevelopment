package by.lashkevich.informationhandling.service.handler.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.entity.impl.TextLeaf;
import by.lashkevich.informationhandling.service.handler.BaseHandler;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler implements BaseHandler {
    private static final Pattern PARAGRAPH_PATTERN = Pattern.compile("(?<=\t).*");
    private static final String FIRST_GLUE_SYMBOL = "\t";
    private static final String SECOND_GLUE_SYMBOL = "\n\n";
    private Optional<BaseHandler> nextHandler;

    public TextHandler() {
        this.nextHandler = Optional.of(new ParagraphHandler());
    }

    public void removeNextHandler() {
        this.nextHandler = Optional.empty();
    }

    public void setNextHandler(ParagraphHandler nextHandler) {
        this.nextHandler = Optional.of(nextHandler);
    }

    @Override
    public TextComponent parse(String text) {
        Matcher matcher = PARAGRAPH_PATTERN.matcher(text);

        if (nextHandler.isPresent()) {
            TextComposite paragraphComposite = new TextComposite(FIRST_GLUE_SYMBOL, SECOND_GLUE_SYMBOL);
            while (matcher.find()) {
                paragraphComposite.add(nextHandler.get().parse(matcher.group()));
            }

            return paragraphComposite;
        } else {
            return new TextLeaf(text);
        }
    }
}
