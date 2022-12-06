package org.sem.classes.models;

public class Class {
    // comment
    private Long id;
    private String className;

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
}
