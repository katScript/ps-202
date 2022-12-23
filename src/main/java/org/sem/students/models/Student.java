/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.students.models;

import org.sem.classes.models.Class;
import org.sem.marks.models.Mark;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private Long id;
    private String roll_number;
    private String fullname;
    private String email;
    private String phone;
    private Boolean gender;
    private Date dob;
    private String address;
    private List<Mark> studentMark;
    private List<Class> classes;
    private Date createdAt;
    private Date updatedAt;

    public Student() {
        studentMark = new ArrayList<>();
    }
    public Student(
            Long id,
            String roll_number,
            String fullname,
            String email,
            String phone,
            Boolean gender,
            Date dob,
            String address
    ) {
        this.id = id;
        this.roll_number = roll_number;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.studentMark = new ArrayList<>();
    }

    public Student(
            Long id,
            String roll_number,
            String fullname,
            String email,
            String phone,
            Boolean gender,
            Date dob,
            String address,
            Date createdAt, Date updatedAt
    ) {
        this.id = id;
        this.roll_number = roll_number;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.studentMark = new ArrayList<>();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Mark> getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(List<Mark> studentMark) {
        this.studentMark = studentMark;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
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
