package org.sem.classes.models;

import org.sem.helper.DateTimeHelper;
import org.sem.students.models.Student;
import org.sem.students.models.StudentTableModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassStudentTableModel extends StudentTableModel {
    protected List<String> columnNames = new ArrayList<>(
            Arrays.asList("ID", "Attendance", "Roll number", "Full name", "Email", "Phone number")
    );

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = students.get(rowIndex);
        switch (columnIndex) {
            case 1:
                return false;
            case 0:
                return s.getId();
            case 2:
                return s.getRoll_number();
            case 3:
                return s.getFullname();
            case 4:
                return s.getEmail();
            case 5:
                return s.getPhone();
        }
        return null;
    }
}
