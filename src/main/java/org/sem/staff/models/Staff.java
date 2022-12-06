/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.staff.models;

import java.sql.Date;

/**
 *
 * @author Win 10 Pro x64
 */
public class Staff {
    private Long id;
    private String staffNo;
    private  String fullname;
    private  String email;
    private String phone;
    private int gender;
    private Date dob;
    private  String address;

    public Staff(long aLong, String string) {
    }

    public Staff(Long id, String staffNo, String fullname, String email, String phone, int gender, Date dob, String address) {
        this.id = id;
        this.staffNo = staffNo;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
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

    
    
}

