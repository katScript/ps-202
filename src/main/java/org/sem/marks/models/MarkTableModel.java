/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.marks.models;

import org.sem.staffs.models.Staff;
import org.sem.students.models.Student;

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
            Arrays.asList("Id", "Subject Name", "Subject code", "Writing first attempt", "Practice first attempt", "Writing second attempt", "Practice second attempt")
    );
    private List<Mark> marks = new ArrayList<>();

    private Integer pageSize = 5;
    private List<List<Mark>> data = new ArrayList<>();
    private Integer totalPage;
    private Boolean isFirst;
    private Boolean isLast;
    private Integer currentPageNumber;

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
    
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
                return m.getSubject().getSubject_name();
            case 2:
                return m.getSubject().getCode();
            case 3:
                return m.getW_first_atterm();
            case 4:
                return m.getP_first_atterm();
            case 5:
                return m.getW_second_atterm();
            case 6:
                return m.getP_second_atterm();
        }
        return null;
    }

    public void setPageData(List<Mark> marks) {
        int i = 0;
        data.clear();
        List<Mark> term = new ArrayList<>();

        for (Mark obj : marks) {
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

    public List<Mark> getCurrentPage() {
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
