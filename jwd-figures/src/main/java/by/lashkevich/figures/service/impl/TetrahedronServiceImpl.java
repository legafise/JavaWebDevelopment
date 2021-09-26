package by.lashkevich.figures.service.impl;

import by.lashkevich.figures.dao.DaoException;
import by.lashkevich.figures.dao.FileFinder;
import by.lashkevich.figures.dao.FileReader;
import by.lashkevich.figures.dao.repository.RepositoryFactory;
import by.lashkevich.figures.dao.repository.specification.Specification;
import by.lashkevich.figures.dao.repository.specification.findspecification.FindTetrahedronByIdSpecification;
import by.lashkevich.figures.entity.Tetrahedron;
import by.lashkevich.figures.service.*;

import java.util.Collection;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class TetrahedronServiceImpl implements TetrahedronService {
    private static final String INVALID_ID_FORMAT_MESSAGE = "Invalid id format";
    private static final String INVALID_ID_MESSAGE = "Invalid tetrahedron id";
    private final ServiceValidator serviceValidator;

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
    public Tetrahedron findTetrahedronById(String id) {
        try {
            List<Tetrahedron> queryResult = RepositoryFactory.getInstance().getTetrahedronRepository()
                    .query(new FindTetrahedronByIdSpecification(Long.parseLong(id)));

            if (!queryResult.isEmpty()) {
                return queryResult.get(0);
            }
            throw new ServiceException(INVALID_ID_MESSAGE);
        } catch (NumberFormatException e) {
            throw new ServiceException(INVALID_ID_FORMAT_MESSAGE);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public double calculateTetrahedronArea(Tetrahedron tetrahedron) {
        DistanceFinder distanceFinder = new DistanceFinder();
        ToDoubleFunction<Tetrahedron> areaFunction = machinedTetrahedron -> Math.sqrt(3) * Math.pow(distanceFinder.
                findDistanceBetweenTwoPoints(machinedTetrahedron.getSecondPoint(),
                        machinedTetrahedron.getFirstPoint()), 2);
        return areaFunction.applyAsDouble(tetrahedron);
    }

    @Override
    public double calculateTetrahedronVolume(Tetrahedron tetrahedron) {
        DistanceFinder distanceFinder = new DistanceFinder();
        ToDoubleFunction<Tetrahedron> volumeFunction = machinedTetrahedron -> (Math.pow(distanceFinder.
                findDistanceBetweenTwoPoints(machinedTetrahedron.getSecondPoint(),
                        machinedTetrahedron.getFirstPoint()), 3) * Math.sqrt(2)) / 12;
        return volumeFunction.applyAsDouble(tetrahedron);
    }

    @Override
    public Collection<Tetrahedron> findAllTetrahedrons() {
        return RepositoryFactory.getInstance().getTetrahedronRepository().findAll();
    }

    @Override
    public Collection<Tetrahedron> sendQuery(Specification specification) {
        return RepositoryFactory.getInstance().getTetrahedronRepository().query(specification);
    }
}
