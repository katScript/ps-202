package org.sem.schedule.models;

import org.sem.helper.DateTimeHelper;
import org.sem.students.models.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectStudentModel  extends AbstractTableModel {
    protected List<String> columnNames = new ArrayList<>(
            Arrays.asList("ID", "Roll number", "Full name", "Email", "Attendance", "Staff No")
    );
    protected List<Student> students = new ArrayList<>();

    private Integer pageSize = 5;
    private List<List<Student>> data = new ArrayList<>();
    private Integer totalPage;
    private Boolean isFirst;
    private Boolean isLast;
    private Integer currentPageNumber;

    public SelectStudentModel() {}

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
                return s.getDaily() != null ? s.getDaily().getPresent() : null;
            case 5:
                return s.getDaily() != null ? s.getDaily().getStaff().getStaffNo() : "";
        }
        return null;
    }

    public Student getAtRow(int rowIndex) {
        return students.get(rowIndex);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setPageData(List<Student> students) {
        int i = 0;
        data.clear();
        List<Student> term = new ArrayList<>();

        for (Student obj : students) {
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

    public List<Student> getCurrentPage() {
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
