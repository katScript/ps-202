package org.sem.students.services;

import org.sem.classes.models.Class;
import org.sem.classes.models.ClassDAO;
import org.sem.marks.models.Mark;
import org.sem.marks.models.MarkDAO;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class StudentService {
    public StudentDAO studentDAO;
    public MarkDAO markDAO;
    public ClassDAO classDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
        markDAO = new MarkDAO();
        classDAO = new ClassDAO();
    }

    public Student getStudent(Long id) {
        try {
            Student student = studentDAO.get(id).orElseThrow(() -> new RuntimeException("Student not found!"));
            List<Mark> markList = markDAO.getByStudentId(student.getId());
            List<Class> classes = classDAO.getByStudentId(student.getId());

            student.setStudentMark(markList);
            student.setClasses(classes);
            return student;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveStudent(
            Long id,
            String rollNumber,
            String fullName,
            String email,
            String phone,
            Boolean gender,
            String dob,
            String address
    ) {
        try {
            Student student = new Student(
                    id,
                    rollNumber,
                    fullName,
                    email,
                    phone,
                    gender,
                    new Date(new SimpleDateFormat().parse(dob).getTime()),
                    address
            );

            studentDAO.save(student);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStudent(Long id) {
        try {
            Student student = studentDAO.get(id).orElseThrow(() -> new RuntimeException("Student id not found!"));

            studentDAO.delete(student);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
