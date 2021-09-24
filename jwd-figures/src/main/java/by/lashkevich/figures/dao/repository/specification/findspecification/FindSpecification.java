package by.lashkevich.figures.dao.repository.specification.findspecification;

import by.lashkevich.figures.dao.repository.specification.Specification;

public interface FindSpecification<T> extends Specification {
    boolean isSpecified(T entity);
}
