package org.sem.marks.service;

import org.sem.classes.models.Class;
import org.sem.marks.models.Mark;
import org.sem.marks.models.MarkDAO;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;
import org.sem.subjects.models.Subject;

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

    public void saveMark(
            Long id,
            Student student,
            Subject subject,
            Float wFirstAttempt,
            Float wSecondAttempt,
            Float pFirstAttempt,
            Float pSecondAttempt
    ) {
        try {
            validate(student, subject, wFirstAttempt, wSecondAttempt, pFirstAttempt, pSecondAttempt);
            Mark mark = new Mark(
                    id,
                    wFirstAttempt,
                    wSecondAttempt,
                    pFirstAttempt,
                    pSecondAttempt
            );

            mark.setSubject(subject);
            mark.setStudent(student);

            markDAO.save(mark);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void validate(
            Student student,
            Subject subject,
            Float wFirstAttempt,
            Float wSecondAttempt,
            Float pFirstAttempt,
            Float pSecondAttempt
    ) {
        if (student == null)
            throw new RuntimeException("Student not found!");
        if (subject == null)
            throw new RuntimeException("Subject can not be null!");
        if (wFirstAttempt == null)
            throw new RuntimeException("Writing point first attempt can not be null!");
        if (wSecondAttempt == null)
            throw new RuntimeException("Writing point second attempt can not be null!");
        if (pFirstAttempt == null)
            throw new RuntimeException("Practice point first attempt can not be null!");
        if (pSecondAttempt == null)
            throw new RuntimeException("Practice point second attempt can not be null!");
    }
}
