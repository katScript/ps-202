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
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            Class cs = null;
            if (rs.next()) {
                cs = new Class(
                        rs.getLong("id"),
                        rs.getString("class_name")
                );
            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(cs);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public List<Class> getAll() {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s`", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Class> result = new ArrayList<>();
            while (rs.next()) {
                result.add(new Class(
                        rs.getLong("id"),
                        rs.getString("class_name")
                ));
            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return result;
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public Class save(Class aClass) {
        try {
            // 1.get connection

            // 2.prepare query
                // 2.1 check is new or not => aClass.getId() != null or not
                // if new => use insert into query else update query

            // 3.execute query

            // 4.process query return data

            // 5.close transaction

            // 6.return result
        } catch (Exception e) {
            // 7.handle errors
        } finally {
            // 8.close database connection
        }

        return null;
    }

    @Override
    public Boolean delete(Class aClass) {
        try {
            // 1.get connection

            // 2.prepare query

            // 3.execute query

            // 4.process query return data true or false => delete success or not

            // 5.close transaction

            // 6.return result
        } catch (Exception e) {
            // 7.handle errors
        } finally {
            // 8.close database connection
        }

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
