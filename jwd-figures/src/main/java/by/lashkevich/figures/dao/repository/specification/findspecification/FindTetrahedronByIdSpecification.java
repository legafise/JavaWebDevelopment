package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.entity.Tetrahedron;

public class FindTetrahedronByIdSpecification implements FindSpecification<Tetrahedron> {
    private long id;

    public FindTetrahedronByIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean isSpecified(Tetrahedron entity) {
        return entity.getId() == id;
    }
}
