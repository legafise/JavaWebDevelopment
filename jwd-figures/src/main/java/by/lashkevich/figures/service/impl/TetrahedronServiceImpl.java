package by.lashkevich.figures.service.impl;

import by.lashkevich.figures.dao.DaoException;
import by.lashkevich.figures.dao.repository.RepositoryFactory;
import by.lashkevich.figures.service.DataParser;
import by.lashkevich.figures.dao.FileFinder;
import by.lashkevich.figures.dao.FileReader;
import by.lashkevich.figures.entity.Tetrahedron;
import by.lashkevich.figures.service.ServiceException;
import by.lashkevich.figures.service.ServiceValidator;
import by.lashkevich.figures.service.TetrahedronService;

import java.util.Collection;
import java.util.List;

public class TetrahedronServiceImpl implements TetrahedronService {
    private ServiceValidator serviceValidator;

    public TetrahedronServiceImpl() {
        serviceValidator = new ServiceValidator();
    }

    @Override
    public List<Tetrahedron> readTetrahedronData(String fileName) throws ServiceException {
        try {
            FileFinder fileFinder = new FileFinder();
            FileReader fileReader = new FileReader();
            DataParser dataParser = new DataParser();
            List<String> readData = fileReader.readFile(fileFinder.findInfoFilePath(fileName));
            return dataParser.parseTetrahedron(readData);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addTetrahedron(Tetrahedron tetrahedron) {
        if (serviceValidator.validateTetrahedron(tetrahedron)) {
            RepositoryFactory.getInstance().getTetrahedronRepository().addTetrahedron(tetrahedron);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Tetrahedron> findAllTetrahedrons() {
        return RepositoryFactory.getInstance().getTetrahedronRepository().findAll();
    }
}
