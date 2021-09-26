package by.lashkevich.figures.service;

import by.lashkevich.figures.dao.repository.specification.Specification;
import by.lashkevich.figures.entity.Tetrahedron;

import java.util.Collection;
import java.util.List;

public interface TetrahedronService {
    List<Tetrahedron> readTetrahedronData(String fileName) throws ServiceException;
    boolean addTetrahedron(Tetrahedron tetrahedron) throws ServiceException;
    Tetrahedron findTetrahedronById(String id);
    double calculateTetrahedronArea(Tetrahedron tetrahedron);
    double calculateTetrahedronVolume(Tetrahedron tetrahedron);
    Collection<Tetrahedron> findAllTetrahedrons();
    Collection<Tetrahedron> sendQuery(Specification specification);
}
