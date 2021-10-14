package by.lashkevich.xml.service.finder;

import java.io.File;

/**
 * Class that find file by file name
 * @author Roman Lashkevich
 */
public class FileFinder {
    private static final String INFO_FILES_DIRECTORY = "data/";

    public String findXmlFilePath(String fileName) {
        return new File(getClass().getClassLoader()
                .getResource(INFO_FILES_DIRECTORY + fileName).getFile()).getAbsolutePath();
    }
}
