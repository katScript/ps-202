package org.sem.subjects.services;

import org.sem.subjects.models.Subject;
import org.sem.subjects.models.SubjectDAO;

public class SubjectService {
    public SubjectDAO subjectDAO;

    public SubjectService() {
        subjectDAO = new SubjectDAO();
    }

    public void save(
            Long id,
            String subjectName,
            String code,
            Double totalHour
    ) {
        try {
            Subject subject = new Subject(
                    id,
                    subjectName,
                    code,
                    totalHour
            );

            subjectDAO.save(subject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
