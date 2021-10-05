package by.lashkevich.informationhandling.dao;

import java.io.File;

/**
 * Class that find file by file name
 * @author Roman Lashkevich
 */
public class FileFinder {
    private static final String INFO_FILES_DIRECTORY = "text/";

    public String findTextFilePath(String fileName) {
        return new File(getClass().getClassLoader()
                .getResource(INFO_FILES_DIRECTORY + fileName).getFile()).getAbsolutePath();
    }
}
