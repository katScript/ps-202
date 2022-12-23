package org.sem.classes.models;

import org.sem.students.models.Student;

import java.sql.Date;
import java.util.List;

public class Class {
    private Long id;
    private String className;
    private List<Student> student;
    private Date createdAt;
    private Date updatedAt;

    public Class() {}

    public Class(
            Long id,
            String className
    ) {
        this.id = id;
        this.className = className;
    }

    public Class(
            Long id,
            String className,
            Date createdAt, Date updatedAt
    ) {
        this.id = id;
        this.className = className;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
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
