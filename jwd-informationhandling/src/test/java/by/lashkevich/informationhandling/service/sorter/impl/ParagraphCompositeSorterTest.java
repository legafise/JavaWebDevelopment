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

class ParagraphCompositeSorterTest {
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
        sorter = new ParagraphCompositeSorter();

        fileName = "TextForParsing.txt";
        testText = "\t It is a (8^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when " +
                "looking at its layout.\n" +
                "\n" +
                "\t Bye.\n" +
                "\n" +
                "\t It has survived- not only (five) centuries, but also the leap into 13<<2 electronic typesetting, " +
                "remaining 30>>>3 essentially ~6&9|(3&4) unchanged. It was popularised in the " +
                "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum " +
                "passages, and more recently with desktop publishing software like Aldus PageMaker including " +
                "versions of Lorem Ipsum.\n" +
                "\n" +
                "\t It is a long established fact that a reader will be distracted by the readable content " +
                "of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum " +
                "is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), " +
                "content here making it look like readable English.";
    }

    @Test
    void sortByParagraphsLengthTest() {
        TextComponent text = handler.parse(fileReader.readStringFromFile(fileFinder.findTextFilePath(fileName)));
        TextComposite composite = (TextComposite) text;
        Assert.assertEquals(testText, sorter.sort(composite).collect());
    }
}