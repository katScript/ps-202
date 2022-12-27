/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.students.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sem.classes.models.Class;
import org.sem.database.DAO;

/**
 *
 * @author ADMIN
 */
public class StudentDAO extends DAO<Student> {
    public static final String TABLE_NAME = "student";

    public StudentDAO() {
        super(TABLE_NAME);
    }

    @Override
    public Optional<Student> get(Long id) {
       try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            // 3.execute query
            // This execute have problem
            ResultSet rs = ps.executeQuery();

            Student st = null;
            if (rs.next()) {
                st = processStudentData(rs);

            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(st);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public List<Student> getAll() {
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
            List<Student> result = new ArrayList<>();

            while (rs.next()) {
                result.add(processStudentData(rs));
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
    public Student save(Student t) {
         try {
            Connection con = this.connector.startConnection().getConnection();

            // 2.prepare query
                // 2.1 check is new or not => aClass.getId() != null or not
                // if new => use insert into query else update query
            String sql;
            PreparedStatement ps;

            if (t.getId() != null) {
                sql = String.format("UPDATE `%s`SET `roll_number` = ?,`fullname` = ?, `email` = ?, `phone` = ?, `gender` = ?, `dob` = ?, `address` = ? WHERE `id` = ?", getTableName());
                ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setLong(8, t.getId());
            } else {
                sql = String.format("INSERT INTO`%s` (`roll_number`, `fullname`, `email`, `phone`, `gender`, `dob`, `address`) VALUES(?,?,?,?,?,?,?)", getTableName());
                ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            }

             ps.setString(1, t.getRoll_number());
             ps.setString(2, t.getFullname());
             ps.setString(3, t.getEmail());
             ps.setString(4, t.getPhone());
             ps.setBoolean(5, t.getGender());
             ps.setDate(6, t.getDob());
             ps.setString(7, t.getAddress());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                t.setId(rs.getLong(1));
                rs.close();
            }
            ps.close();

            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connector.closeConnection();
        }
    }

    @Override
    public Boolean delete(Student t) {
        try {
            Connection con = this.connector.startConnection().getConnection();

            // 2.prepare query
                // 2.1 check is new or not => aClass.getId() != null or not
                // if new => use insert into query else update query
            String sql = String.format("DELETE FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, t.getId());

            Boolean result = ps.execute();
            ps.close();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connector.closeConnection();
        }
    }

    public List<Student> getByClass(Class aClass) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` AS `s` INNER JOIN `student_class` AS `sc` ON `s`.`id` = `sc`.`student_id` WHERE `sc`.`class_id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, aClass.getId());

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Student> result = new ArrayList<>();

            while (rs.next()) {
                result.add(processStudentData(rs));
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


    public List<Student> searchByNameWithClass(Class aClass, String name) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = "SELECT * FROM `" + getTableName() + "` AS `s` INNER JOIN `student_class` AS `sc` ON `s`.`id` = `sc`.`student_id` WHERE `sc`.`class_id` = ? AND (`s`.`fullname` is null or `s`.`fullname` like concat('%', ?, '%'))";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, aClass.getId());
            ps.setString(2, name);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Student> result = new ArrayList<>();

            while (rs.next()) {
                result.add(processStudentData(rs));
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


    public List<Student> getStudentNotInClass(Class aClass) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` AS `s` WHERE `s`.`id` NOT IN(SELECT `st`.`id` FROM `student` AS `st` LEFT JOIN `student_class` AS `sc` ON `st`.`id` = `sc`.`student_id` WHERE `sc`.`class_id` = ?)", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, aClass.getId());

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Student> result = new ArrayList<>();

            while (rs.next()) {
                result.add(processStudentData(rs));
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

    public List<Student> searchByName(String name) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = "SELECT * FROM `" + getTableName() + "` WHERE (`fullname` is null or `fullname` like concat('%', ?, '%'))";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Student> result = new ArrayList<>();

            while (rs.next()) {
                result.add(processStudentData(rs));
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

    private Student processStudentData(ResultSet rs) {
        try {
            return new Student(
                    rs.getLong("id"),
                    rs.getString("roll_number"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getBoolean("gender"),
                    rs.getDate("dob"),
                    rs.getString("address"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}