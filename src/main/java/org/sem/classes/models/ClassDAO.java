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
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
                // 2.1 check is new or not => aClass.getId() != null or not
                // if new => use insert into query else update query
                 String sql;
            PreparedStatement ps;
            
            if (aClass.getId() != null) {
                sql = String.format("UPDATE `%s` SET  id = ?, Class name = ?", getTableName());
                ps = con.prepareStatement(sql);
                
                ps.setString(1, aClass.Long());
                ps.setString(2, aClass.getClassName());
                
            } else {
                sql = String.format("INSERT INTO `%s` (class_Name, id) VALUES (?,?,?)", getTableName());
                ps = con.prepareStatement(sql);
                
                ps.setString(1, aClass.getClassName());
                ps.setString(2, aClass.getLong());
                
            }

            // 3.execute query
            Boolean result = ps.execute();

            // 4.process query return data
            if (result) {
                ResultSet rs = ps.getGeneratedKeys();
                aClass.setId(rs.getLong(1));
                
                rs.close();
            }

            // 5.close transaction
            ps.close();

            // 6.return result
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);

        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }

        return null;
    }

    @Override
    public Boolean delete(Class aClass) {
        try {
            // 1.get connection
            Connection con = this.connector
                   .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("DELETE FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, aClass.getId());
           

            // 3.execute query
            Boolean result = ps.execute();

            // 4.process query return data true or false => delete success or not
            ps.close();

            // 5.close transaction
            return result;

            // 6.return result
        } catch (Exception e) {
            // 7.handle errors
             throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }

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
