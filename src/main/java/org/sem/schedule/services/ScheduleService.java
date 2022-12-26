package org.sem.schedule.services;

import org.sem.classes.models.Class;
import org.sem.helper.DateTimeHelper;
import org.sem.schedule.models.Daily;
import org.sem.schedule.models.DailyDAO;
import org.sem.schedule.models.Schedule;
import org.sem.schedule.models.ScheduleDAO;
import org.sem.staffs.models.Staff;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;
import org.sem.subjects.models.Subject;

import java.util.List;

public class ScheduleService {
    public ScheduleDAO scheduleDAO;
    public DailyDAO dailyDAO;
    public StudentDAO studentDAO;

    public ScheduleService() {
        scheduleDAO = new ScheduleDAO();
        dailyDAO = new DailyDAO();
        studentDAO = new StudentDAO();
    }

    public void saveSchedule(
            Long id,
            Class classData,
            String day,
            String startTime,
            String endTime,
            Subject subject
    ) {
        validate(classData, day, startTime, endTime, subject);

        Schedule schedule = new Schedule(
                id,
                DateTimeHelper.stringToDate(day),
                startTime,
                endTime
        );
        schedule.setClassS(classData);
        schedule.setSubject(subject);

        scheduleDAO.save(schedule);
    }

    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleDAO.get(id).orElseThrow(() -> new RuntimeException("Schedule not found!"));
        scheduleDAO.delete(schedule);
    }

    private void validate(Class classData, String day, String startTime, String endTime, Subject subject) {
        if (classData == null)
            throw new RuntimeException("Class must not be null!");
        if (day == null)
            throw new RuntimeException("Day must not be null!");
        if (startTime == null)
            throw new RuntimeException("Start time must not be null!");
        if (endTime == null)
            throw new RuntimeException("End time must not be null!");
        if (subject == null)
            throw new RuntimeException("Subject must not be null!");
    }
}
