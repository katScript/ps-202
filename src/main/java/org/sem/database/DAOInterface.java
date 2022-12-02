package org.sem.database;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAOInterface<T> {
    Optional<T> get(Integer id);
    List<T> getAll();
    T save(T t);
    Boolean delete(T t);
}