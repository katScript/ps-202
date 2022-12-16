/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.staff.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Win 10 Pro x64
 */
public class StaffTableModel extends AbstractTableModel {
  private List<String> columnNames = new ArrayList<>(
            Arrays.asList("id", "staff_no", "full_name", "email","phone","gender","dob","address")
    );
     private List<Staff> staffs = new ArrayList<>();

    public void setData(List<Staff> staffs) {
        setStaff(staffs);
        fireTableDataChanged();
    }

    public List<Staff> getSubjects() {
        return staffs;
    }
    private void setStaff(List<Staff> staffs) {
 this.staffs = staffs;    
    }
// get col name
    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public int getRowCount() {
        return staffs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Staff s = staffs.get(rowIndex);
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
                return s.getGender();
            case 6:
                return s.getDob();
            case 7:
                return s.getAddress();    
        }

        return null;    }
    
}
