package org.sem.students.services;

import org.sem.classes.models.Class;
import org.sem.classes.models.ClassDAO;
import org.sem.helper.DateTimeHelper;
import org.sem.marks.models.Mark;
import org.sem.marks.models.MarkDAO;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;

import java.util.List;
import java.util.regex.Pattern;

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
            validate(rollNumber,fullName,email,phone,gender,dob,address);

            Student student = new Student(
                    id,
                    rollNumber,
                    fullName,
                    email,
                    phone,
                    gender,
                    DateTimeHelper.stringToDate(dob),
                    address
            );

            studentDAO.save(student);
        } catch (Exception e) {
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

    private void validate(
            String rollNumber,
          String fullName,
          String email,
          String phone,
          Boolean gender,
          String dob,
          String address
    ) {
        if (rollNumber == null || rollNumber.equals(""))
            throw new RuntimeException("Roll number must not be null!");
        if (fullName == null || fullName.equals(""))
            throw new RuntimeException("FullName must not be null!");
        if (email == null || email.equals(""))
            throw new RuntimeException("Email must not be null!");
        if (phone == null || phone.equals(""))
            throw new RuntimeException("Phone must not be null!");
        if (dob == null || dob.equals(""))
            throw new RuntimeException("Dob must not be null!");
        if (address == null || address.equals(""))
            throw new RuntimeException("Address must not be null!");

        if (!Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches())
            throw new RuntimeException("Email not valid!");

        if (!Pattern.compile("^\\d{10}$").matcher(phone).matches())
            throw new RuntimeException("Phone number not valid!");
    }
}
