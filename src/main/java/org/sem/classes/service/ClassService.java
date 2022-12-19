package org.sem.classes.service;

import org.sem.classes.models.Class;
import org.sem.classes.models.ClassDAO;

public class ClassService {
    public ClassDAO classDAO;

    public ClassService() {
        classDAO = new ClassDAO();
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
}
