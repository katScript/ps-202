package org.sem.schedule.services;

import org.sem.classes.models.Class;
import org.sem.schedule.models.Daily;
import org.sem.schedule.models.DailyDAO;
import org.sem.schedule.models.Schedule;
import org.sem.staffs.models.Staff;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;

import java.util.List;

public class DailyService {
    public DailyDAO dailyDAO;
    public StudentDAO studentDAO;

    public DailyService() {
        dailyDAO = new DailyDAO();
    }

    public void getStudentDaily(Student student, Schedule schedule) {
        Daily daily = dailyDAO.getByStudentAndSchedule(student, schedule).orElse(null);
        student.setDaily(daily);
    }

    public void markPresent(Staff staff, Student student, Schedule schedule) {
        Daily daily = student.getDaily() != null ? student.getDaily() : new Daily(null, null);
        daily.setStaff(staff);
        daily.setStudent(student);
        daily.setSchedule(schedule);
        daily.setPresent(true);

        dailyDAO.save(daily);
    }

    public void markNotPresent(Staff staff, Student student, Schedule schedule) {
        Daily daily = student.getDaily() != null ? student.getDaily() : new Daily(null, null);
        daily.setStaff(staff);
        daily.setStudent(student);
        daily.setSchedule(schedule);
        daily.setPresent(false);

        dailyDAO.save(daily);
    }
}
