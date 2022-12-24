/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.staffs.models;

import org.sem.classes.models.Class;
import org.sem.helper.DateTimeHelper;
import org.sem.students.models.Student;

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

    private Integer pageSize = 5;
    private List<List<Staff>> data = new ArrayList<>();
    private Integer totalPage;
    private Boolean isFirst;
    private Boolean isLast;
    private Integer currentPageNumber;

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

    public void setPageData(List<Staff> staffsData) {
        int i = 0;
        data.clear();
        List<Staff> term = new ArrayList<>();

        for (Staff obj : staffsData) {
            if (i < pageSize) {
                term.add(obj);
                i++;
            } else {
                data.add(term);
                term = new ArrayList<>() {{ add(obj); }};
                i = 1;
            }
        }

        if (!term.isEmpty()) {
            data.add(term);
        }

        if (data.size() == 0)
            data.add(term);

        totalPage = data.size();
        setCurrentPageNumber(1);
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPageNumber() {
        return currentPageNumber;
    }

    public List<Staff> getCurrentPage() {
        return data.get(currentPageNumber - 1);
    }

    public void setCurrentPageNumber(Integer currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
        setFirst(currentPageNumber.equals(1));
        setLast(currentPageNumber.equals(totalPage));
        setData(getCurrentPage());
    }

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

