package by.lashkevich.informationhandling.service.impl;

import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.service.ServiceException;
import by.lashkevich.informationhandling.service.TextCompositeService;
import by.lashkevich.informationhandling.service.sorter.CompositeSorter;
import by.lashkevich.informationhandling.service.sorter.impl.LexemeCompositeSorter;
import by.lashkevich.informationhandling.service.sorter.impl.ParagraphCompositeSorter;
import by.lashkevich.informationhandling.service.sorter.impl.WordCompositeSorter;

public class TextCompositeServiceImpl implements TextCompositeService {
    private static final String INCORRECT_CHARACTER_MESSAGE = "Incorrect symbol was received";

    @Override
    public TextComposite sortParagraphsBySentencesNumber(TextComposite composite) {
        CompositeSorter sorter = new ParagraphCompositeSorter();
        return sorter.sort(composite);
    }

    @Override
    public TextComposite sortWordsInSentencesByLengths(TextComposite composite) {
        CompositeSorter sorter = new WordCompositeSorter();
        return sorter.sort(composite);
    }

    @Override
    public TextComposite sortLexemes(TextComposite composite, String character) {
        if (character.length() > 1) {
            throw new ServiceException(INCORRECT_CHARACTER_MESSAGE);
        }

        CompositeSorter sorter = new LexemeCompositeSorter(character.charAt(0));
        return sorter.sort(composite);
    }
}