package org.sem.schedule.views;

import org.sem.classes.models.Class;
import org.sem.context.Context;
import org.sem.context.Redirect;
import org.sem.schedule.models.Schedule;
import org.sem.schedule.models.ScheduleDAO;
import org.sem.schedule.models.ScheduleTableModel;
import org.sem.students.models.Student;
import org.sem.students.views.Attendance;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ScheduleStudentList extends ViewPanel {
    private javax.swing.JButton firstBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lastBtn;
    private javax.swing.JPanel main;
    private javax.swing.JButton nextBtn;
    private javax.swing.JComboBox<String> pageSelect;
    private javax.swing.JButton previousBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;

    public ScheduleTableModel scheduleTableModel;
    public Student studentData;
    public ScheduleDAO scheduleDAO;
    public Class classData;

    public ScheduleStudentList(Context context) {
        super(context);
    }

    @Override
    protected void beforeInitComponents() {
        scheduleTableModel = new ScheduleTableModel();
        studentData = (Student) getContext().getSession().getData("student");
        scheduleDAO = new ScheduleDAO();
        classData = (Class) getContext().getSession().getData("class");
    }

    @Override
    protected void initComponents() {
        main = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lastBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        pageSelect = new javax.swing.JComboBox<>();
        previousBtn = new javax.swing.JButton();
        firstBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jButton1.setText("Back");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SCHEDULE MANAGEMENT SYSTEM");

        lastBtn.setBackground(new java.awt.Color(204, 204, 255));
        lastBtn.setText("Last");

        nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/next.png"))); // NOI18N

        pageSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        pageSelect.setPreferredSize(new java.awt.Dimension(72, 23));

        previousBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/left-chevron.png"))); // NOI18N

        firstBtn.setBackground(new java.awt.Color(204, 204, 255));
        firstBtn.setText("First");

        searchInput.setPreferredSize(new java.awt.Dimension(64, 23));

        searchBtn.setBackground(new java.awt.Color(255, 229, 229));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-interface-symbol.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Rollnumer");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("C2109I4533");

        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 204));
        jButton2.setText("View Detail");
        jButton2.setPreferredSize(new java.awt.Dimension(107, 39));

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(firstBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastBtn)
                        .addGap(17, 17, 17))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)))
                .addContainerGap())
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previousBtn)
                    .addComponent(firstBtn)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastBtn)
                        .addComponent(nextBtn)
                        .addComponent(pageSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBtn)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    @Override
    protected void afterInitComponents() {
        super.afterInitComponents();
        jTable1.setModel(scheduleTableModel);
        changeTableModelData(scheduleDAO.getAllByClass(classData));
    }

    @Override
    protected void handleEvent() {
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new org.sem.students.views.EditPage(getContext()));
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = jTable1.getSelectedRow();
                    Long id = (Long) jTable1.getValueAt(row, 0);

                    if (id != null) {
                        Schedule schedule = scheduleDAO.get(id).orElseThrow(() -> new RuntimeException("Schedule not found!"));
                        getContext().getSession().setData("schedule", schedule);
                        Redirect.target(new Attendance(getContext()));
                    }
                } catch (Exception ex) {
                    getContext().getSession().setData("message", ex.getMessage());
                    showMessage();
                }
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = searchInput.getText();

                List<Schedule> schedules = scheduleDAO.searchBySubjectNameWithClass(searchValue, classData);
                changeTableModelData(schedules);
            }
        });

        pageSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer pageNumber = pageSelect.getSelectedIndex() + 1;
                changePageNumber(pageNumber);
            }
        });

        lastBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer totalPage = scheduleTableModel.getTotalPage();
                changePageNumber(totalPage);
            }
        });

        firstBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePageNumber(1);
            }
        });

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pageNumber = pageSelect.getSelectedIndex();
                changePageNumber(pageNumber + 2);
            }
        });

        previousBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pageNumber = pageSelect.getSelectedIndex();
                changePageNumber(pageNumber);
            }
        });
    }

    @Override
    public JPanel getMainLayer() {
        return main;
    }

    public void changeTableModelData(List<Schedule> schedules) {
        scheduleTableModel.setPageData(schedules);
        updateToolBar();
    }

    public void changePageNumber(Integer pageNumber) {
        scheduleTableModel.setCurrentPageNumber(pageNumber);
        updateToolBar();
        pageSelect.setSelectedIndex(scheduleTableModel.getCurrentPageNumber() - 1);
    }

    private void updateToolBar() {
        Integer length = scheduleTableModel.getTotalPage();
        String[] pageNumbers = new String[length];
        for (int i = 1; i <= length; ++i) {
            pageNumbers[i - 1] = String.valueOf(i);
        }

        pageSelect.setModel(new javax.swing.DefaultComboBoxModel<>(pageNumbers));
        lastBtn.setEnabled(!scheduleTableModel.getLast());
        firstBtn.setEnabled(!scheduleTableModel.getFirst());

        nextBtn.setEnabled(!scheduleTableModel.getLast());
        previousBtn.setEnabled(!scheduleTableModel.getFirst());
    }
}
