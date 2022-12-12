package org.sem.classes.models;

import org.sem.students.models.Student;

import java.util.List;

public class Class {
    private Long id;
    private String className;
    private List<Student> student;

    public Class() {}

    public Class(
            Long id,
            String className
    ) {
        this.id = id;
        this.className = className;
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
}
