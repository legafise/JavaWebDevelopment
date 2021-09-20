package by.lashkevich.figures.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public List<String> readFile(String fileName) throws DaoException {
        try {
            return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
