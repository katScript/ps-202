package org.sem.marks.service;

import org.sem.classes.models.Class;
import org.sem.marks.models.Mark;
import org.sem.marks.models.MarkDAO;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;

import java.util.List;

public class MarkService {
    public MarkDAO markDAO;
    public StudentDAO studentDAO;

    public MarkService() {
        studentDAO = new StudentDAO();
        markDAO = new MarkDAO();
    }

    public List<Mark> getByStudentId(Long id) {
        try {
            Student student = studentDAO.get(id).orElseThrow(() -> new RuntimeException("Student id not found!"));

            return markDAO.getByStudent(student);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
