package org.sem.database;

import java.util.List;
import java.util.Optional;

public interface DAOInterface<T> {
    // Optional => use custom type Class => exists data Class(id, name), => not exists null object
    Optional<T> get(Long id);
    List<T> getAll();
    T save(T t);
    Boolean delete(T t);
}