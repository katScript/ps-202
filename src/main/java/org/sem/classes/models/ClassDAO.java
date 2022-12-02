package org.sem.classes.models;

import org.sem.database.DAOInterface;
import org.sem.database.connection.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassDAO implements DAOInterface<Class> {
    private Connector connector;
    private final String tableName = "class";

    public ClassDAO() {
        this.connector = new Connector();
    }

    @Override
    public Optional<Class> get(Integer id) {
        try {
            Connection con = this.connector
                    .startConnection().getConnection();

            String sql = String.format("SELECT * FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Class cs = null;
            if (rs.next()) {
                cs = new Class(
                        rs.getLong("id"),
                        rs.getString("class_name")
                );
            }

            ps.close();
            rs.close();

            return Optional.ofNullable(cs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connector.closeConnection();
        }
    }

    @Override
    public List<Class> getAll() {
        try {
            Connection con = this.connector
                    .startConnection().getConnection();

            String sql = String.format("SELECT * FROM `%s`", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Class> result = new ArrayList<>();
            while (rs.next()) {
                result.add(new Class(
                        rs.getLong("id"),
                        rs.getString("class_name")
                ));
            }

            ps.close();
            rs.close();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connector.closeConnection();
        }
    }

    @Override
    public Class save(Class aClass) {
        return null;
    }

    @Override
    public Boolean delete(Class aClass) {
        return null;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public String getTableName() {
        return tableName;
    }
}
