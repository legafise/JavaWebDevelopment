package by.lashkevich.informationhandling.service;

import by.lashkevich.informationhandling.entity.impl.TextComposite;

import java.util.List;

public interface TextCompositeService {
    TextComposite sortParagraphsBySentencesNumber(TextComposite composite);
    TextComposite sortWordsInSentencesByLengths(TextComposite composite);
    TextComposite sortLexemes(TextComposite composite, String character);
}
