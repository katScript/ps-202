/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.marks.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sem.classes.models.Class;
import org.sem.database.DAO;
import org.sem.database.DAOInterface;
import org.sem.database.connection.Connector;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;
import org.sem.subjects.models.Subject;
import org.sem.subjects.models.SubjectDAO;

/**
 *
 * @author 84379
 */
public class MarkDAO extends DAO<Mark> {
    public static final String TABLE_NAME = "mark";

    private SubjectDAO subjectDAO;
    private StudentDAO studentDAO;

    public MarkDAO() {
        super(TABLE_NAME);
        subjectDAO = new SubjectDAO();
        studentDAO = new StudentDAO();
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
                cs = processMarkData(rs);
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
                result.add(processMarkData(rs));
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
                sql = String.format("UPDATE `%s` SET w_first_atterm = ?, w_second_atterm = ?, p_first_atterm = ?, p_second_atterm = ?, student_id = ?, subject_id = ? WHERE id = ?", getTableName());
                ps = con.prepareStatement(sql);
                
                ps.setFloat(1, t.getW_first_atterm());
                ps.setFloat(2, t.getW_second_atterm());
                ps.setFloat(3, t.getP_first_atterm());
                ps.setFloat(4, t.getP_second_atterm());
                ps.setLong(5, t.getStudent().getId());
                ps.setLong(6, t.getSubject().getId());
                ps.setLong(7, t.getId());
            } else {
                sql = String.format("INSERT INTO `%s` (w_first_atterm, w_second_atterm, p_first_atterm,p_second_atterm, student_id, subject_id) VALUES (?,?,?,?,?,?)", getTableName());
                ps = con.prepareStatement(sql);
                
                ps.setFloat(1, t.getW_first_atterm());
                ps.setFloat(2, t.getW_second_atterm());
                ps.setFloat(3, t.getP_first_atterm());
                ps.setFloat(4, t.getP_second_atterm());
                ps.setLong(5, t.getStudent().getId());
                ps.setLong(6, t.getSubject().getId());
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

    public List<Mark> getByStudent(Student student) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `student_id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, student.getId());

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Mark> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processMarkData(rs));
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

    public List<Mark> searchByNameAndStudent(String name, Student student) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = "SELECT * FROM `" + getTableName() + "` AS `m` LEFT JOIN `subject` AS `s` ON `s`.`id` = `m`.`subject_id` WHERE (`s`.`subject_name` is null or `s`.`subject_name` like concat('%', ?, '%')) AND `student_id` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setLong(1, student.getId());

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<org.sem.marks.models.Mark> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processMarkData(rs));
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

    private Mark processMarkData(ResultSet rs) {
        try {
            Mark mark = new Mark(
                    rs.getLong("id"),
                    rs.getFloat("w_first_atterm"),
                    rs.getFloat("w_second_atterm"),
                    rs.getFloat("p_first_atterm"),
                    rs.getFloat("p_second_atterm"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
            );

            Student student = studentDAO.get(rs.getLong("student_id"))
                    .orElseThrow(() -> new RuntimeException("Student not exists!"));
            Subject subject = subjectDAO.get(rs.getLong("subject_id"))
                    .orElseThrow(() -> new RuntimeException("Subject not exists!"));

            mark.setStudent(student);
            mark.setSubject(subject);

            return mark;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
