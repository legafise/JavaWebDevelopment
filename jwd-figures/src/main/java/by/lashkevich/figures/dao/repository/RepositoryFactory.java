package by.lashkevich.figures.dao.repository;

import by.lashkevich.figures.dao.repository.impl.TetrahedronRepositoryImpl;

public class RepositoryFactory {
    private static final RepositoryFactory instance = new RepositoryFactory();
    private final TetrahedronRepository tetrahedronRepository;

    public RepositoryFactory() {
        tetrahedronRepository = new TetrahedronRepositoryImpl();
    }

    public static RepositoryFactory getInstance() {
        return instance;
    }

    public TetrahedronRepository getTetrahedronRepository() {
        return tetrahedronRepository;
    }
}
