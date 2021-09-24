package by.lashkevich.figures.dao.repository;

import by.lashkevich.figures.dao.DaoException;
import by.lashkevich.figures.dao.repository.specification.Specification;
import by.lashkevich.figures.entity.Tetrahedron;

import java.util.Collection;
import java.util.List;

public interface TetrahedronRepository {
    Collection<Tetrahedron> findAll();
    void addTetrahedron(Tetrahedron tetrahedron);
    void removeTetrahedronById(long id);
    void updateTetrahedronById(long id, Tetrahedron tetrahedron);
    List<Tetrahedron> query(Specification specification) throws DaoException;
}
