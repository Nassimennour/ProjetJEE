package Dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
    void save(T t);
    void update(T t);
    void delete(T t);
    Optional<T> findById(long id);
    List<T> findAll();
    boolean existsById(long id);
}
