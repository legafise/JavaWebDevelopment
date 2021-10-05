package by.lashkevich.informationhandling.service.sorter.impl;

import by.lashkevich.informationhandling.dao.FileFinder;
import by.lashkevich.informationhandling.dao.FileReader;
import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.service.handler.impl.TextHandler;
import by.lashkevich.informationhandling.service.sorter.CompositeSorter;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LexemeCompositeSorterTest {
    private String testText;
    private String fileName;
    private FileFinder fileFinder;
    private FileReader fileReader;
    private TextHandler handler;
    private CompositeSorter sorter;

    @BeforeEach
    void setUp() {
        fileFinder = new FileFinder();
        fileReader = new FileReader();
        handler = new TextHandler();
        sorter = new LexemeCompositeSorter('o');

        fileName = "TextForParsing.txt";
        testText = "\t also electronic into not only (five) 13<<2 30>>>3 but centuries, essentially has It leap " +
                "remaining survived- the typesetting, unchanged. ~6&9|(3&4) containing desktop Lorem Lorem more " +
                "of of popularised software versions 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) Aldus and in including " +
                "Ipsum Ipsum. It Letraset like PageMaker passages, " +
                "publishing recently release sheets the the was with with\n" +
                "\n" +
                "\t looking content layout. long of a a a at be by distracted established fact is It its " +
                "page readable reader that the when will look more-or-less opposed (Content content distribution" +
                " normal of of point to (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 a as English. has here here), " +
                "Ipsum is it it letters, like making readable that The using using\n" +
                "\n" +
                "\t looking layout. of (8^5|1&2<<(2|5>>2&71))|1200 a a a at be established fact is It its page" +
                " reader that when will\n" +
                "\n" +
                "\t Bye.";
    }

    @Test
    void sortBySymbolInLexemeOrByAlphabetTest() {
        TextComponent text = handler.parse(fileReader.readStringFromFile(fileFinder.findTextFilePath(fileName)));
        TextComposite composite = (TextComposite) text;
        Assert.assertEquals(testText, sorter.sort(composite).collect());
    }
}