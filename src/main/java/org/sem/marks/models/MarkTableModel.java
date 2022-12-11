/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.marks.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author 84379
 */
public class MarkTableModel extends AbstractTableModel{
    private List<String> columnNames = new ArrayList<>(
            Arrays.asList("Id", "W_first_atterm", "W_second_atterm", "P_first_atterm", "P_second_atterm")
    );
    
    private List<Mark> marks = new ArrayList<>();
    
    public void setData(List<Mark> marks) {
        setMarks(marks);
        fireTableDataChanged();
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public int getRowCount() {
        return marks.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mark m = marks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return m.getId();
            case 1:
                return m.getW_first_atterm();
            case 2:
                return m.getW_second_atterm();
            case 3:
                return m.getP_first_atterm();
            case 4:
                return m.getP_second_atterm();
        }
        return null;
    }
}
