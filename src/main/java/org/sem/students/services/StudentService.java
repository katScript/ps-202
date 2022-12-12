package org.sem.students.services;

import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentService {
    public StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
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
