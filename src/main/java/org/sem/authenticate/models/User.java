package org.sem.authenticate.models;

import java.sql.Timestamp;

public class User {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public User() {}

    public User(
            Long id,
            String userName,
            String password,
            String email
    ) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User(
            Long id,
            String userName,
            String password,
            String email,
            Timestamp createdAt, Timestamp updatedAt
    ) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
