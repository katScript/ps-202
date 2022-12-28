package org.sem.schedule.models;

import org.sem.helper.DateTimeHelper;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScheduleTableModel extends AbstractTableModel {

    private List<String> columnNames = new ArrayList<>(
            Arrays.asList("Id", "Subject", "Subject Code", "Day", "Start time", "End time")
    );

    private List<Schedule> schedules = new ArrayList<>();

    private Integer pageSize = 5;
    private List<List<Schedule>> data = new ArrayList<>();
    private Integer totalPage;
    private Boolean isFirst;
    private Boolean isLast;
    private Integer currentPageNumber;

    @Override
    public int getRowCount() {
        return schedules.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Schedule c = schedules.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getSubject().getSubject_name();
            case 2:
                return c.getSubject().getCode();
            case 3:
                return DateTimeHelper.dateToString(c.getDate(), "dd/MM/yyyy");
            case 4:
                return c.getStartTime();
            case 5:
                return c.getEndTime();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void setData(List<Schedule> schedules) {
        setSchedules(schedules);
        fireTableDataChanged();
    }

    public void setPageData(List<Schedule> schedules) {
        int i = 0;
        data.clear();
        List<Schedule> term = new ArrayList<>();

        for (Schedule obj : schedules) {
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

    public List<Schedule> getCurrentPage() {
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
