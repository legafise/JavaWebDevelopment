package by.lashkevich.informationhandling.service.sorter.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.service.sorter.CompositeSorter;

public class LexemeCompositeSorter implements CompositeSorter {
    private char symbol;

    public LexemeCompositeSorter(char symbol) {
        this.symbol = symbol;
    }

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
                if (countOverlap(sentence.getChild(j).collect(), symbol)
                        < countOverlap(sentence.getChild(j + 1).collect(), symbol)) {
                    swapElements(sentence, j);
                } else if (countOverlap(sentence.getChild(j).collect(), symbol)
                        == countOverlap(sentence.getChild(j + 1).collect(), symbol)) {
                    sortByAlphabet(sentence, j);
                }
            }
        }
    }

    private int countOverlap(String word, char symbol) {
        int counter = 0;
        for (int i = 0; word.length() > i; i++) {
            if (word.charAt(i) == symbol) {
                counter++;
            }
        }

        return counter;
    }

    private void swapElements(TextComposite sentence, int j) {
        TextComponent temp = sentence.getChild(j);
        sentence.setChild(j, sentence.getChild(j + 1));
        sentence.setChild(j + 1, temp);
    }

    private void sortByAlphabet(TextComposite sentence, int j) {
        if (sentence.getChild(j).collect().toLowerCase()
                .compareTo(sentence.getChild(j + 1).collect().toLowerCase()) > 0) {
            swapElements(sentence, j);
        }
    }
}
