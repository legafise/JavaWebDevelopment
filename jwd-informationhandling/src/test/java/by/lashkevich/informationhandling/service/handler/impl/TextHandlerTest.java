package by.lashkevich.informationhandling.service.handler.impl;

import by.lashkevich.informationhandling.dao.FileFinder;
import by.lashkevich.informationhandling.dao.FileReader;
import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextHandlerTest {
    private String testText;
    private String fileName;
    private FileFinder fileFinder;
    private FileReader fileReader;
    private TextHandler handler;

    @BeforeEach
    void setUp() {
        fileFinder = new FileFinder();
        fileReader = new FileReader();
        handler = new TextHandler();

        fileName = "TextForParsing.txt";
        testText = " It has survived- not only (five) centuries, but also the leap into 13<<2 electronic typesetting," +
                " remaining 30>>>3 essentially ~6&9|(3&4) unchanged. It was popularised in the " +
                "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem " +
                "Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker " +
                "including versions of Lorem Ipsum.";
    }

    @Test
    void parseTextTest() {
        TextComponent text = handler.parse(fileReader.readStringFromFile(fileFinder.findTextFilePath(fileName)));
        TextComposite composite = (TextComposite) text;
        Assert.assertEquals(testText, composite.getChild(0).collect());
    }
}