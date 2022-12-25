/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.staffs.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sem.authenticate.models.User;
import org.sem.authenticate.models.UserDAO;
import org.sem.database.DAO;

/**
 * @author Win 10 Pro x64
 */
public class StaffDAO extends DAO<Staff> {
    public UserDAO userDAO;
    public StaffDAO() {
        super("staff");
        userDAO = new UserDAO();
    }

    @Override
    public Optional<Staff> get(Long id) {
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
//4
            Staff sf = null;
            if (rs.next()) {
                sf = processStaffData(rs);

            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(sf);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public List<Staff> getAll() {
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
            List<Staff> result = new ArrayList<>();

            while (rs.next()) {
                result.add(processStaffData(rs));
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
    public Staff save(Staff t) {
        // 1.get connection
        try {
            Connection con = this.connector.startConnection().getConnection();

            // 2.prepare query
            // 2.1 check is new or not => aClass.getId() != null or not
            // if new => use insert into query else update query
            String sql;
            PreparedStatement ps;

            if (t.getId() != null) {
                sql = String.format("UPDATE `%s`SET staff_no=?,full_name=?,email=?,phone=?,gender=?,dob=?,address=?, user_id=? WHERE id = ?", getTableName());
                ps = con.prepareStatement(sql);

                ps.setString(1, t.getStaffNo());
                ps.setString(2, t.getFullname());
                ps.setString(3, t.getEmail());
                ps.setString(4, t.getPhone());
                ps.setBoolean(5, t.getGender());
                ps.setDate(6, t.getDob());
                ps.setString(7, t.getAddress());
                ps.setLong(8, t.getUser().getId());
                ps.setLong(9, t.getId());
            } else {
                sql = String.format("INSERT INTO`%s` (staff_no,full_name,email,phone,gender,dob,address, user_id) VALUES(?,?,?,?,?,?,?,?)", getTableName());
                ps = con.prepareStatement(sql);

                ps.setString(1, t.getStaffNo());
                ps.setString(2, t.getFullname());
                ps.setString(3, t.getEmail());
                ps.setString(4, t.getPhone());
                ps.setBoolean(5, t.getGender());
                ps.setDate(6, t.getDob());
                ps.setString(7, t.getAddress());
                ps.setLong(8, t.getUser().getId());
            }

            Boolean result = ps.execute();
            if (result) {
                ResultSet rs = ps.getGeneratedKeys();
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
    public Boolean delete(Staff t) {
        // 1.get connection
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

    public Optional<Staff> getByUser(User user) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` AS `s` LEFT JOIN `user` AS `u` ON `u`.`id` = `s`.`user_id` WHERE `u`.`id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, user.getId());
            // 3.execute query
            // This execute have problem
            ResultSet rs = ps.executeQuery();
//4
            Staff sf = null;
            if (rs.next()) {
                sf = processStaffData(rs);

            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(sf);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    public List<Staff> searchByName(String name) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = "SELECT * FROM `" + getTableName() + "` WHERE (`full_name` is null or `full_name` like concat('%', ?, '%'))";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Staff> result = new ArrayList<>();

            while (rs.next()) {
                result.add(processStaffData(rs));
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

    private Staff processStaffData(ResultSet rs) {
        try {
            Staff staff = new Staff(
                    rs.getLong("id"),
                    rs.getString("staff_no"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getBoolean("gender"),
                    rs.getDate("dob"),
                    rs.getString("address"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
            );

            User user = userDAO.findByStaff(staff).orElseThrow(() -> new RuntimeException("User not exists!"));
            staff.setUser(user);

            return staff;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
