package by.lashkevich.figures.dao.repository.impl;

import by.lashkevich.figures.dao.DaoException;
import by.lashkevich.figures.dao.repository.TetrahedronRepository;
import by.lashkevich.figures.dao.repository.specification.Specification;
import by.lashkevich.figures.dao.repository.specification.findspecification.FindSpecification;
import by.lashkevich.figures.dao.repository.specification.sortspecification.SortSpecification;
import by.lashkevich.figures.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {
    private static final String INCORRECT_SPECIFICATION_MESSAGE = "Incorrect specification";
    private static final String INCORRECT_ID_MESSAGE = "Incorrect id";
    private final List<Tetrahedron> tetrahedrons;
    private long idCounter;

    public TetrahedronRepositoryImpl() {
        this.tetrahedrons = new ArrayList<>();
    }

    @Override
    public Collection<Tetrahedron> findAll() {
        return Collections.unmodifiableList(tetrahedrons);
    }

    @Override
    public void addTetrahedron(Tetrahedron tetrahedron) {
        tetrahedron.setId(idCounter++);
        tetrahedrons.add(tetrahedron);
    }

    @Override
    public void removeTetrahedronById(long id) {
        Tetrahedron removingTetrahedron = tetrahedrons.stream()
                .filter(tetrahedron -> tetrahedron.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DaoException(INCORRECT_ID_MESSAGE));
        tetrahedrons.remove(removingTetrahedron);
    }

    @Override
    public void updateTetrahedronById(long id, Tetrahedron tetrahedron) {
        removeTetrahedronById(id);
        tetrahedron.setId(id);
        tetrahedrons.add(tetrahedron);
    }

    @Override
    public List<Tetrahedron> query(Specification specification) throws DaoException {
        List<Tetrahedron> tetrahedronList;

        if (specification instanceof FindSpecification) {
            FindSpecification<Tetrahedron> findSpecification = (FindSpecification) specification;
            tetrahedronList = tetrahedrons.stream()
                    .filter(findSpecification::isSpecified)
                    .collect(Collectors.toList());
        } else if (specification instanceof SortSpecification) {
            SortSpecification<Tetrahedron> sortSpecification = (SortSpecification) specification;
            tetrahedronList = tetrahedrons.stream()
                    .sorted(sortSpecification.getComparator())
                    .collect(Collectors.toList());
        } else {
            throw new DaoException(INCORRECT_SPECIFICATION_MESSAGE);
        }

        return tetrahedronList;
    }
}
