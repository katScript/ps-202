package org.sem.database.connection;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private String urlConnection;
    private String user;
    private String password;

    private Connection connection;

    public Connector() {
        this.urlConnection = "jdbc:mysql://localhost:3306/sem";
        this.user = "root";
        this.password = "18072001@Kat";
        this.jdbcDriven();
    }

    private void jdbcDriven() {
        try {
            new Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connector startConnection() {
        try {
            if (this.getConnection() != null && !this.getConnection().isClosed())
                return this;

            Connection con = DriverManager.getConnection(
                    this.getUrlConnection(),
                    this.getUser(),
                    this.getPassword()
            );

            this.setConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrlConnection() {
        return urlConnection;
    }

    public void setUrlConnection(String urlConnection) {
        this.urlConnection = urlConnection;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
