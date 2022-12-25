/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.subjects.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sem.database.DAO;
import org.sem.database.DAOInterface;
import org.sem.database.connection.Connector;

/**
 *
 * @author 84379
 */
public class SubjectDAO extends DAO<Subject> {
    public static final String TABLE_NAME = "subject";

    public SubjectDAO() {
        super(TABLE_NAME);
    }

    @Override
    public Optional<Subject> get(Long id) {
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
            org.sem.subjects.models.Subject cs = null;
            if (rs.next()) {
                cs = processBindSubjectData(rs);
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
    public List<Subject> getAll() {
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
            List<org.sem.subjects.models.Subject> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processBindSubjectData(rs));
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
    public Subject save(Subject t) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();
            
            // 2.prepare query
                // 2.1 check is new or not => aClass.getId() != null or not
                // if new => use insert into query else update query
            String sql;
            PreparedStatement ps;
            
            if (t.getId() != null) {
                sql = String.format("UPDATE `%s` SET subject_name = ?, code = ?, total_hour = ? WHERE id = ?", getTableName());
                ps = con.prepareStatement(sql);
                
                ps.setString(1, t.getSubject_name());
                ps.setString(2, t.getCode());
                ps.setDouble(3, t.getTotalhour());
                ps.setLong(4, t.getId());
            } else {
                sql = String.format("INSERT INTO `%s` (subject_name, code, total_hour) VALUES (?,?,?)", getTableName());
                ps = con.prepareStatement(sql);
                
                ps.setString(1, t.getSubject_name());
                ps.setString(2, t.getCode());
                ps.setDouble(3, t.getTotalhour());
            }

            // 3.execute query
            Boolean result = ps.execute();
            
            // 4.process query return data
            if (result) {
                ResultSet rs = ps.getGeneratedKeys();
                t.setId(rs.getLong(1));
                
                rs.close();
            }
            
            // 5.close transaction
            ps.close();
            
            // 6.return result
            return t;
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public Boolean delete(Subject t) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("DELETE FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, t.getId());

            // 3.execute query
            Boolean result = ps.execute();

            // 5.close transaction
            ps.close();

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

    public List<Subject> searchByName(String name) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = "SELECT * FROM `" + getTableName() + "` WHERE (`subject_name` is null or `subject_name` like concat('%', ?, '%'))";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<org.sem.subjects.models.Subject> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processBindSubjectData(rs));
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

    private Subject processBindSubjectData(ResultSet rs) {
        try {
            return new Subject(
                    rs.getLong("id"),
                    rs.getString("subject_name"),
                    rs.getString("code"),
                    rs.getDouble("total_hour"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
