package org.sem.classes.models;

import org.sem.students.models.Student;

import java.sql.Timestamp;
import java.util.List;

public class Class {
    private Long id;
    private String className;
    private List<Student> student;
    private Timestamp createdAt;
    private Timestamp updatedAt;

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
            Timestamp createdAt, Timestamp updatedAt
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
