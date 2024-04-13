package Dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    void save(T t);
    void update(T t);
    void delete(T t);
    Optional<T> findById(long id);
    List<T> findAll();
}
