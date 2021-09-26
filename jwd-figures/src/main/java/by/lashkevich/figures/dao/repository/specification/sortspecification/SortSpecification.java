package by.lashkevich.figures.dao.repository.specification.sortspecification;

import by.lashkevich.figures.dao.repository.specification.Specification;

import java.util.Comparator;

public interface SortSpecification<T> extends Specification {
    Comparator<T> getComparator();
}
