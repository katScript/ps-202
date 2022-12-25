package org.sem.schedule.models;

import org.sem.classes.models.Class;
import org.sem.subjects.models.Subject;

import java.sql.Date;
import java.sql.Timestamp;

public class Schedule {
    private Long id;
    private Class classS;
    private Date date;
    private String startTime;
    private String endTime;
    private Subject subject;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Schedule() {}

    public Schedule(
            Long id,
            Date date,
            String startTime,
            String endTime
    ) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Schedule(
            Long id,
            Date date,
            String startTime,
            String endTime,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public Class getClassS() {
        return classS;
    }

    public void setClassS(Class classS) {
        this.classS = classS;
    }
}
