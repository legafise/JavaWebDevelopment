package by.lashkevich.figures.dao.repository.specification.sortspecification;

import java.util.Comparator;

public interface SortSpecification<T> {
    Comparator<T> getComparator();
}
