package by.lashkevich.informationhandling.service.sorter.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.Lexeme;
import by.lashkevich.informationhandling.entity.impl.PunctuationMark;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.service.sorter.CompositeSorter;

public class WordCompositeSorter implements CompositeSorter {
    @Override
    public TextComposite sort(TextComposite composite) {
        for (TextComponent paragraph : composite.getComponents()) {
            TextComposite paragraphComposite = (TextComposite) paragraph;
            handleSentences(paragraphComposite);
        }

        return composite;
    }

    private void handleSentences(TextComposite paragraphs) {
        for (TextComponent sentence : paragraphs.getComponents()) {
            TextComposite sentenceComposite = (TextComposite) sentence;
            handleLexemes(sentenceComposite);
        }
    }

    private void handleLexemes(TextComposite sentence) {
        for (int i = 0; i < sentence.getComponents().size(); i++) {
            for (int j = 0; j < sentence.getComponents().size() - i - 1; j++) {
                if (isValidElementForSorting(sentence, j)) {
                    TextComponent temp = ((Lexeme) sentence.getChild(j)).getChild(0);
                    ((Lexeme) sentence.getChild(j))
                            .setChild(0, ((Lexeme) sentence.getChild(j + 1)).getChild(0));
                    ((Lexeme) sentence.getChild(j + 1))
                            .setChild(0, (temp));
                }
            }
        }
    }

    private boolean isValidElementForSorting(TextComposite sentence, int j) {
        return sentence.getChild(j) instanceof Lexeme && sentence.getChild(j + 1) instanceof Lexeme
                && !(((Lexeme) sentence.getChild(j)).getChild(0) instanceof PunctuationMark)
                && !(((Lexeme) sentence.getChild(j + 1)).getChild(0) instanceof PunctuationMark)
                && (((Lexeme) sentence.getChild(j)).getChild(0).collect().length())
                > (((Lexeme) sentence.getChild(j + 1)).getChild(0).collect().length());
    }
}
