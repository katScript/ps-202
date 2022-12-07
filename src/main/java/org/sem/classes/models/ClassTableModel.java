package org.sem.classes.models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassTableModel extends AbstractTableModel {
    private List<String> columnNames = new ArrayList<>(
            Arrays.asList("Id", "Class name")
    );

    private List<Class> classes = new ArrayList<>();

    // will have demo when create searching feature
    public void setData(List<Class> classes) {
        setClasses(classes);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public int getRowCount() {
        return classes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Class c = classes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getClassName();
        }

        return null;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
