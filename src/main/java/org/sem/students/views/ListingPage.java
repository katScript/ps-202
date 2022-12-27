package org.sem.students.views;

import org.sem.context.Context;
import org.sem.context.Session;
import org.sem.dashboard.views.Dashboard;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;
import org.sem.students.models.StudentTableModel;
import org.sem.students.services.StudentService;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListingPage extends ViewPanel {
    private javax.swing.JButton firstBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lastBtn;
    private javax.swing.JPanel main;
    private javax.swing.JButton nextBtn;
    private javax.swing.JComboBox<String> pageSelect;
    private javax.swing.JButton previousBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;

    public StudentDAO studentDAO;
    public StudentService studentService;
    public StudentTableModel studentTableModel;

    public ListingPage(Context context) {
        super(context, "Student");
    }

    @Override
    protected void beforeInitComponents() {
        studentDAO = new StudentDAO();
        studentService = new StudentService();
        studentTableModel = new StudentTableModel();
        getContext().getSession().setData("student", null);
    }

    @Override
    protected void initComponents() {
        main = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lastBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        pageSelect = new javax.swing.JComboBox<>();
        firstBtn = new javax.swing.JButton();
        previousBtn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(7).setMinWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("STUDENT MANAGEMENT SYSTEM");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editing.png"))); // NOI18N
        jButton1.setText("Update");
        jButton1.setPreferredSize(new java.awt.Dimension(110, 27));

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.setPreferredSize(new java.awt.Dimension(110, 27));

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton3.setText("Add new");

        lastBtn.setBackground(new java.awt.Color(204, 204, 255));
        lastBtn.setText("Last");

        nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/next.png"))); // NOI18N

        pageSelect.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pageSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        pageSelect.setPreferredSize(new java.awt.Dimension(72, 23));

        firstBtn.setBackground(new java.awt.Color(204, 204, 255));
        firstBtn.setText("First");

        previousBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/left-chevron.png"))); // NOI18N

        jButton6.setBackground(new java.awt.Color(255, 255, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jButton6.setText("Back");

        searchInput.setMinimumSize(new java.awt.Dimension(64, 23));
        searchInput.setPreferredSize(new java.awt.Dimension(64, 23));

        searchBtn.setBackground(new java.awt.Color(255, 229, 229));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-interface-symbol.png"))); // NOI18N

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jButton3)
                                .addGap(200, 200, 200)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(searchBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(previousBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pageSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(20, 20, 20))
                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lastBtn)
                                                .addComponent(nextBtn))
                                        .addComponent(pageSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(previousBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(firstBtn)
                                                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
        );
    }

    protected void afterInitComponents() {
        super.afterInitComponents();

        jTable1.setModel(studentTableModel);
        changeTableModelData(studentDAO.getAll());
    }

    @Override
    protected void handleEvent() {
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = jTable1.getSelectedRow();
                    Long id = (Long) jTable1.getValueAt(row, 0);

                    Student student = studentDAO.get(id).orElse(null);

                    if (student != null) {
                        getContext().getSession().setData("student", student);
                        EditPage page = new EditPage(getContext());
                        getContext().changeLayer(page.getMainLayer());
                    }

                } catch (Exception ex) {
                    getContext().getSession().setData("message", ex.getCause().getMessage());
                    showMessage();
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = jTable1.getSelectedRow();
                    Long id = (Long) jTable1.getValueAt(row, 0);

                    if (id != null) {
                        if (showOptionPanel("Delete student id " + id, "Delete student alert!")) {
                            studentService.deleteStudent(id);
                            ListingPage page = new ListingPage(getContext());
                            getContext().changeLayer(page.getMainLayer());
                        }
                    }

                } catch (Exception ex) {
                    getContext().getSession().setData("message", ex.getCause().getMessage());
                    showMessage();
                }
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditPage page = new EditPage(getContext());
                getContext().changeLayer(page.getMainLayer());
            }
        });

        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard page = new Dashboard(getContext());
                getContext().changeLayer(page.getMainLayer());
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = searchInput.getText();

                List<Student> students = studentDAO.searchByName(searchValue);
                changeTableModelData(students);
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
                Integer totalPage = studentTableModel.getTotalPage();
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

    public void changeTableModelData(List<Student> students) {
        studentTableModel.setPageData(students);
        updateToolBar();
    }

    public void changePageNumber(Integer pageNumber) {
        studentTableModel.setCurrentPageNumber(pageNumber);
        updateToolBar();
        pageSelect.setSelectedIndex(studentTableModel.getCurrentPageNumber() - 1);
    }

    private void updateToolBar() {
        Integer length = studentTableModel.getTotalPage();
        String[] pageNumbers = new String[length];
        for (int i = 1; i <= length; ++i) {
            pageNumbers[i - 1] = String.valueOf(i);
        }

        pageSelect.setModel(new javax.swing.DefaultComboBoxModel<>(pageNumbers));
        lastBtn.setEnabled(!studentTableModel.getLast());
        firstBtn.setEnabled(!studentTableModel.getFirst());

        nextBtn.setEnabled(!studentTableModel.getLast());
        previousBtn.setEnabled(!studentTableModel.getFirst());
    }
}
