/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.subjects.models;

/**
 *
 * @author 84379
 */
public class Subject {
    private Long id;
    private String subject_name;
    private String code;
    private Double total_hour;

    public Subject() {
    }

    public Subject(Long id, String subject_name, String code, Double total_hour) {
        this.id = id;
        this.subject_name = subject_name;
        this.code = code;
        this.total_hour = total_hour;
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
    
}
