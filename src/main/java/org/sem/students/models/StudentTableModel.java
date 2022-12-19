package org.sem.students.models;

import org.sem.helper.DateTimeHelper;
import org.sem.marks.models.Mark;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    private List<String> columnNames = new ArrayList<>(
            Arrays.asList("ID", "Roll number", "Full name", "Email", "Phone number", "Gender", "Date of bird", "Address")
    );

    private List<Student> students = new ArrayList<>();

    public void setData(List<Student> students) {
        setStudents(students);
        fireTableDataChanged();
    }


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
            case 0:
                return s.getId();
            case 1:
                return s.getRoll_number();
            case 2:
                return s.getFullname();
            case 3:
                return s.getEmail();
            case 4:
                return s.getPhone();
            case 5:
                return s.getGender() ? "Male" : "Female";
            case 6:
                return DateTimeHelper.dateToString(s.getDob());
            case 7:
                return s.getAddress();
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
