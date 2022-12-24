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

    private Integer pageSize = 5;
    private List<List<Class>> data = new ArrayList<>();
    private Integer totalPage;
    private Boolean isFirst;
    private Boolean isLast;
    private Integer currentPageNumber;

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

    public void setPageData(List<Class> students) {
        int i = 0;
        data.clear();
        List<Class> term = new ArrayList<>();

        for (Class obj : students) {
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

    public List<Class> getCurrentPage() {
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
