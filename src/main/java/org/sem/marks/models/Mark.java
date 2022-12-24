/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.marks.models;

import org.sem.students.models.Student;
import org.sem.subjects.models.Subject;

import java.sql.Timestamp;

/**
 *
 * @author 84379
 */
public class Mark {
    private Long id;
    private Float w_first_atterm;
    private Float w_second_atterm;
    private Float p_first_atterm;
    private Float p_second_atterm;
    private Student student;
    private Subject subject;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Mark() {
    }

    public Mark(Long id, Float w_first_atterm, Float w_second_atterm, Float p_first_atterm, Float p_second_atterm) {
        this.id = id;
        this.w_first_atterm = w_first_atterm;
        this.w_second_atterm = w_second_atterm;
        this.p_first_atterm = p_first_atterm;
        this.p_second_atterm = p_second_atterm;
    }

    public Mark(Long id, Float w_first_atterm, Float w_second_atterm, Float p_first_atterm, Float p_second_atterm,
                Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.w_first_atterm = w_first_atterm;
        this.w_second_atterm = w_second_atterm;
        this.p_first_atterm = p_first_atterm;
        this.p_second_atterm = p_second_atterm;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getW_first_atterm() {
        return w_first_atterm;
    }

    public void setW_first_atterm(Float w_first_atterm) {
        this.w_first_atterm = w_first_atterm;
    }

    public Float getW_second_atterm() {
        return w_second_atterm;
    }

    public void setW_second_atterm(Float w_second_atterm) {
        this.w_second_atterm = w_second_atterm;
    }

    public Float getP_first_atterm() {
        return p_first_atterm;
    }

    public void setP_first_atterm(Float p_first_atterm) {
        this.p_first_atterm = p_first_atterm;
    }

    public Float getP_second_atterm() {
        return p_second_atterm;
    }

    public void setP_second_atterm(Float p_second_atterm) {
        this.p_second_atterm = p_second_atterm;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
