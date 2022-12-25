package org.sem.schedule.models;

import org.sem.staffs.models.Staff;
import org.sem.students.models.Student;

import java.sql.Timestamp;

public class Daily {
    private Long id;
    private Staff staff;
    private Student student;
    private Schedule schedule;
    private Boolean present;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Daily() {}

    public Daily(
            Long id,
            Boolean present
    ) {
        this.id = id;
        this.present = present;
    }

    public Daily(
            Long id,
            Boolean present,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {
        this.id = id;
        this.present = present;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
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
