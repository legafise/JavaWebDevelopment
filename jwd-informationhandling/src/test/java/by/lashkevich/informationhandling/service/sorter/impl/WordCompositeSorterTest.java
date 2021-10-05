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

import static org.junit.jupiter.api.Assertions.*;

class WordCompositeSorterTest {
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
        sorter = new WordCompositeSorter();

        fileName = "TextForParsing.txt";
        testText = "\t It has not- only survived (five) but, the also leap into centuries 13<<2 remaining electronic," +
                " typesetting 30>>>3 essentially ~6&9|(3&4) unchanged. It in was the popularised " +
                "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) of of the and with more with like Lorem Ipsum, Aldus Lorem " +
                "Ipsum sheets release desktop Letraset passages recently software versions PageMaker including " +
                "containing publishing.\n" +
                "\n" +
                "\t a a a It is be by of at the its long fact that will page when reader layout content looking" +
                " readable distracted established. of The point using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 a is it of as to has-or-less that more Ipsum using, normal letters opposed distribution (Content it), here here look like making content English readable.\n" +
                "\n" +
                "\t a It is (8^5|1&2<<(2|5>>2&71))|1200 a a be of at its fact that will page when reader layout" +
                " looking established.\n" +
                "\n" +
                "\t Bye.";
    }

    @Test
    void sortByWordLengthTest() {
        TextComponent text = handler.parse(fileReader.readStringFromFile(fileFinder.findTextFilePath(fileName)));
        TextComposite composite = (TextComposite) text;
        Assert.assertEquals(testText, sorter.sort(composite).collect());
    }
}