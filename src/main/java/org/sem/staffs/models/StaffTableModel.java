/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.staffs.models;

import org.sem.helper.DateTimeHelper;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Win 10 Pro x64
 */
public class StaffTableModel extends AbstractTableModel {
    private List<String> columnNames = new ArrayList<>(
            Arrays.asList("ID", "Staff no", "Full name", "Email", "Phone number", "Gender", "Date of bird", "Address")
    );

    private List<Staff> staff = new ArrayList<>();

    public void setData(List<Staff> staff) {
        setStaff(staff);
        fireTableDataChanged();
    }


    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public int getRowCount() {
        return staff.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Staff s = staff.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getId();
            case 1:
                return s.getStaffNo();
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

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}

