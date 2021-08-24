package by.lashkevich.bills.dao;

import java.io.File;

public class FilePathFinder {
    private static final String INFO_FILES_DIRECTORY = "info/";

    public String findInfoFilePath(String fileName) {
        return new File(getClass().getClassLoader()
                .getResource(INFO_FILES_DIRECTORY + fileName).getFile()).getAbsolutePath();
    }
}
