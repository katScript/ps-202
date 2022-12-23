package org.sem.authenticate.models;

import java.sql.Date;

public class User {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Date createdAt;
    private Date updatedAt;

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
            Date createdAt, Date updatedAt
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
