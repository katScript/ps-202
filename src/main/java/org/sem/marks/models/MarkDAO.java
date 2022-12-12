/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.marks.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sem.database.DAO;
import org.sem.database.DAOInterface;
import org.sem.database.connection.Connector;
import org.sem.students.models.StudentDAO;
import org.sem.subjects.models.SubjectDAO;

/**
 *
 * @author 84379
 */
public class MarkDAO extends DAO<Mark> {
    public static final String TABLE_NAME = "mark";

    public MarkDAO() {
        super(TABLE_NAME);
    }

    @Override
    public Optional<Mark> get(Long id) {
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
            org.sem.marks.models.Mark cs = null;
            if (rs.next()) {
                cs = new org.sem.marks.models.Mark(
                        rs.getLong("id"),
                        rs.getFloat("w_first_atterm"),
                        rs.getFloat("w_second_atterm"),
                        rs.getFloat("p_first_atterm"),
                        rs.getFloat("p_second_atterm")
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
    public List<Mark> getAll() {
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
            List<org.sem.marks.models.Mark> result = new ArrayList<>();
            while (rs.next()) {
                result.add(new org.sem.marks.models.Mark(
                        rs.getLong("id"),
                        rs.getFloat("w_first_atterm"),
                        rs.getFloat("w_second_atterm"),
                        rs.getFloat("p_first_atterm"),
                        rs.getFloat("p_second_atterm")
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
    public Mark save(Mark t) {
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
                sql = String.format("UPDATE `%s` SET w_first_atterm = ?, w_second_atterm = ?, p_first_atterm = ?, p_second_atterm = ? WHERE id = ?", getTableName());
                ps = con.prepareStatement(sql);
                
                ps.setFloat(1, t.getW_first_atterm());
                ps.setFloat(2, t.getW_second_atterm());
                ps.setFloat(3, t.getP_first_atterm());
                ps.setFloat(4, t.getP_second_atterm());
                ps.setLong(5, t.getId());
            } else {
                sql = String.format("INSERT INTO `%s` (w_first_atterm, w_second_atterm, p_first_atterm,p_second_atterm) VALUES (?,?,?,?)", getTableName());
                ps = con.prepareStatement(sql);
                
                ps.setFloat(1, t.getW_first_atterm());
                ps.setFloat(2, t.getW_second_atterm());
                ps.setFloat(3, t.getP_first_atterm());
                ps.setFloat(4, t.getP_second_atterm());
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
    public Boolean delete(Mark t) {
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

    public List<Mark> getByStudentId(Long id) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `student_id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Mark> result = new ArrayList<>();
            while (rs.next()) {
                result.add(new org.sem.marks.models.Mark(
                        rs.getLong("id"),
                        rs.getFloat("w_first_atterm"),
                        rs.getFloat("w_second_atterm"),
                        rs.getFloat("p_first_atterm"),
                        rs.getFloat("p_second_atterm")
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
}
