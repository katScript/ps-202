package org.sem.authenticate.models;

import org.sem.database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO extends DAO<User> {
    public UserDAO() {
        super("user");
    }

    @Override
    public Optional<User> get(Long id) {
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

            User us = null;
            if (rs.next()) {
                us = processBindUserData(rs);

            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(us);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public List<User> getAll() {
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
            List<User> result = new ArrayList<>();

            while (rs.next()) {
                result.add(processBindUserData(rs));
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
    public User save(User user) {
        try {
            Connection con = this.connector.startConnection().getConnection();

            // 2.prepare query
            // 2.1 check is new or not => aClass.getId() != null or not
            // if new => use insert into query else update query
            String sql;
            PreparedStatement ps;

            if (user.getId() != null) {
                sql = String.format("UPDATE `%s`SET `user_name` = ?,`password` = ?, `email` = ? WHERE `id` = ?", getTableName());
                ps = con.prepareStatement(sql);

                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getEmail());
                ps.setLong(4, user.getId());
            } else {
                sql = String.format("INSERT INTO`%s` (`user_name`, `password`, `email`) VALUES(?,?,?)", getTableName());
                ps = con.prepareStatement(sql);

                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getEmail());
            }

            Boolean result = ps.execute();
            if (result) {
                ResultSet rs = ps.getGeneratedKeys();
                user.setId(rs.getLong(1));
                rs.close();
            }
            ps.close();

            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connector.closeConnection();
        }
    }

    @Override
    public Boolean delete(User user) {
        try {
            Connection con = this.connector.startConnection().getConnection();

            // 2.prepare query
            // 2.1 check is new or not => aClass.getId() != null or not
            // if new => use insert into query else update query
            String sql = String.format("DELETE FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, user.getId());

            Boolean result = ps.execute();
            ps.close();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connector.closeConnection();
        }
    }

    public Optional<User> findByUserName(String userName) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `user_name` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            // 3.execute query
            // This execute have problem
            ResultSet rs = ps.executeQuery();

            User us = null;
            if (rs.next()) {
                us = processBindUserData(rs);
            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(us);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    public Optional<User> getUserAuth(String userName, String password) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `user_name` = ? AND `password` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            // 3.execute query
            // This execute have problem
            ResultSet rs = ps.executeQuery();

            User us = null;
            if (rs.next()) {
                us = processBindUserData(rs);
            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(us);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    private User processBindUserData(ResultSet rs) {
        try {
            return new User(
                    rs.getLong("id"),
                    rs.getString("user_name"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getDate("created_at"),
                    rs.getDate("updated_at")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
