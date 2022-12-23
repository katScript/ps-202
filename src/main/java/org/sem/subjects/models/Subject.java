/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.subjects.models;

import java.sql.Date;

/**
 *
 * @author 84379
 */
public class Subject {
    private Long id;
    private String subject_name;
    private String code;
    private Double total_hour;
    private Date createdAt;
    private Date updatedAt;

    public Subject() {
    }

    public Subject(Long id, String subject_name, String code, Double total_hour) {
        this.id = id;
        this.subject_name = subject_name;
        this.code = code;
        this.total_hour = total_hour;
    }

    public Subject(Long id, String subject_name, String code, Double total_hour,
                   Date createdAt, Date updatedAt
    ) {
        this.id = id;
        this.subject_name = subject_name;
        this.code = code;
        this.total_hour = total_hour;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Subject setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public Subject setSubject_name(String subject_name) {
        this.subject_name = subject_name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Subject setCode(String code) {
        this.code = code;
        return this;
    }

    public Double getTotalhour() {
        return total_hour;
    }

    public Subject setTotalhour(Double total_hour) {
        this.total_hour = total_hour;
        return this;
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
