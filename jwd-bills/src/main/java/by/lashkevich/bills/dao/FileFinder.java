package by.lashkevich.bills.dao;

import java.io.File;

/**
 * Class that find file by file name
 * @author Roman Lashkevich
 */
public class FileFinder {
    private static final String INFO_FILES_DIRECTORY = "info/";

    public String findInfoFilePath(String fileName) {
        return new File(getClass().getClassLoader()
                .getResource(INFO_FILES_DIRECTORY + fileName).getFile()).getAbsolutePath();
    }

    public File findInfoFile(String fileName) {
        return new File(getClass().getClassLoader()
                .getResource(INFO_FILES_DIRECTORY + fileName).getFile());
    }
}
