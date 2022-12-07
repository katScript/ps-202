package org.sem.subjects.models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubjectTableModel extends AbstractTableModel {

    private List<String> columnNames = new ArrayList<>(
            Arrays.asList("Id", "Subject name", "Subject code", "Total hour")
    );

    private List<Subject> subjects = new ArrayList<>();

    public void setData(List<Subject> subjects) {
        setSubjects(subjects);
        fireTableDataChanged();
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    // get col name
    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public int getRowCount() {
        return subjects.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Subject s = subjects.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getId();
            case 1:
                return s.getSubject_name();
            case 2:
                return s.getCode();
            case 3:
                return s.getTotalhour();
        }

        return null;
    }
}
