package org.sem.database;

import org.sem.database.connection.Connector;

import java.util.List;
import java.util.Optional;

public abstract class DAO<T> implements DAOInterface<T> {
    protected Connector connector;
    protected String tableName;

    public DAO (String tableName) {
        this.connector = new Connector();
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    @Override
    public abstract Optional<T> get(Long id);

    @Override
    public abstract List<T> getAll();

    @Override
    public abstract T save(T t);

    @Override
    public abstract Boolean delete(T t);
}
