package org.sem.classes.service;

import org.sem.classes.models.Class;
import org.sem.classes.models.ClassDAO;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;

import java.util.List;

public class ClassService {
    public ClassDAO classDAO;
    public StudentDAO studentDAO;

    public ClassService() {
        classDAO = new ClassDAO();
        studentDAO = new StudentDAO();
    }

    public void saveClass(
            Long id,
            String className
    ) {
        try {
            Class aClass = new Class(
                    id,
                    className
            );

            classDAO.save(aClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteClass(Long id) {
        try {
            Class aClass = classDAO.get(id).orElseThrow(() -> new RuntimeException("Class id not found!"));

            classDAO.delete(aClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeStudent(Long classId, Long studentId) {
        try {
            Class aClass = classDAO.get(classId).orElseThrow(() -> new RuntimeException("Class id not found!"));
            Student student = studentDAO.get(studentId).orElseThrow(() -> new RuntimeException("Class id not found!"));

            classDAO.removeStudent(aClass, student);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addStudentToClass(Long classId, Long studentId) {
        try {
            Class aClass = classDAO.get(classId).orElseThrow(() -> new RuntimeException("Class id not found!"));
            Student student = studentDAO.get(studentId).orElseThrow(() -> new RuntimeException("Class id not found!"));

            classDAO.addStudentToClass(aClass, student);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
