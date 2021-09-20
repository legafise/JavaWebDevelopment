package by.lashkevich.figures.dao.repository.impl;

import by.lashkevich.figures.dao.repository.TetrahedronRepository;
import by.lashkevich.figures.dao.repository.specification.Specification;
import by.lashkevich.figures.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {
    private final Map<Long, Tetrahedron> tetrahedrons;
    private long idCounter;

    public TetrahedronRepositoryImpl() {
        this.tetrahedrons = new HashMap<>();
    }

    @Override
    public Tetrahedron findById(long id) {
        return tetrahedrons.get(id);
    }

    @Override
    public List<Tetrahedron> findAll() {
        return new ArrayList<>(tetrahedrons.values());
    }

    @Override
    public void addTetrahedron(Tetrahedron tetrahedron) {
        tetrahedron.setId(idCounter++);
        tetrahedrons.put(tetrahedron.getId(), tetrahedron);
    }

    @Override
    public void removeTetrahedronById(long id) {
        tetrahedrons.remove(id);
    }

    @Override
    public void updateTetrahedronById(long id, Tetrahedron tetrahedron) {
        tetrahedrons.remove(id);
        tetrahedron.setId(id);
        tetrahedrons.put(id, tetrahedron);
    }

    @Override
    public List<Tetrahedron> query(Specification specification) {
        return null;
    }
}
