/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.staffs.models;

import java.sql.Timestamp;
import java.sql.Date;

/**
 * @author Win 10 Pro x64
 */
public class Staff {
    private Long id;
    private String staffNo;
    private String fullname;
    private String email;
    private String phone;
    // Boolean = Integer => 0, 1
    private Boolean gender; // (0 ,1);
    private Date dob;
    private String address;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Staff() {
    }
    public Staff(
            Long id,
            String staffNo,
            String fullname,
            String email,
            String phone,
            Boolean gender,
            Date dob,
            String address
    ) {
        this.id = id;
        this.staffNo = staffNo;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public Staff(
            Long id,
            String staffNo,
            String fullname,
            String email,
            String phone,
            Boolean gender,
            Date dob,
            String address,
            Timestamp createdAt, Timestamp updatedAt
    ) {
        this.id = id;
        this.staffNo = staffNo;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
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

