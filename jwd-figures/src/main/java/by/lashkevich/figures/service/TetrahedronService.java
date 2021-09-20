package by.lashkevich.figures.service;

import by.lashkevich.figures.entity.Tetrahedron;

import java.util.Collection;
import java.util.List;

public interface TetrahedronService {
    List<Tetrahedron> readTetrahedronData(String fileName) throws ServiceException;
    boolean addTetrahedron(Tetrahedron tetrahedron) throws ServiceException;
    Collection<Tetrahedron> findAllTetrahedrons();
}
