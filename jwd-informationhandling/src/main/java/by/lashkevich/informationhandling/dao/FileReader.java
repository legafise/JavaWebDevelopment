package by.lashkevich.informationhandling.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public String readStringFromFile(String fileName) throws DaoException {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
