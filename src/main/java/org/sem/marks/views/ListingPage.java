/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.marks.views;


import javax.swing.JPanel;

import org.sem.context.Context;
import org.sem.context.Redirect;
import org.sem.marks.models.Mark;
import org.sem.marks.models.MarkDAO;
import org.sem.marks.models.MarkTableModel;
import org.sem.marks.service.MarkService;
import org.sem.students.models.Student;
import org.sem.view.ViewPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author 84379
 */
public class ListingPage extends ViewPanel {
    private javax.swing.JButton firstBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lastBtn;
    private javax.swing.JPanel main;
    private javax.swing.JButton nextBtn;
    private javax.swing.JComboBox<String> pageSelect;
    private javax.swing.JButton previousBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;

    public MarkDAO markDAO;
    public MarkTableModel markTableModel;
    public MarkService markService;
    public Student studentData;

    public ListingPage(Context context) {
        super(context, "Student / Mark");
    }

    @Override
    protected void beforeInitComponents() {
        markDAO = new MarkDAO();
        markTableModel = new MarkTableModel();
        markService = new MarkService();

        studentData = (Student) getContext().getSession().getData("student");
        getContext().getSession().removeData("mark");
        getContext().getSession().removeData("subject");
    }

    @Override
    protected void initComponents() {
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        main = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lastBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        pageSelect = new javax.swing.JComboBox<>();
        previousBtn = new javax.swing.JButton();
        firstBtn = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jEditorPane1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "W_first_atterm", "W_second_atterm", "P_first_atterm", "P_second_atterm"
            }
        ) {
            java.lang.Class[] types = new java.lang.Class [] {
                java.lang.Long.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };

            public java.lang.Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(500);
        }

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editing.png"))); // NOI18N
        jButton1.setText("Update");
        
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MARK MANAGEMENT SYSTEM");

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        jButton2.setText("Delete");

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton3.setText("Add new");

        lastBtn.setBackground(new java.awt.Color(204, 204, 255));
        lastBtn.setText("Last");

        nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/next.png"))); // NOI18N

        pageSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        pageSelect.setMinimumSize(new java.awt.Dimension(72, 23));

        previousBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/left-chevron.png"))); // NOI18N

        firstBtn.setBackground(new java.awt.Color(204, 204, 255));
        firstBtn.setText("First");

        jButton8.setBackground(new java.awt.Color(255, 255, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jButton8.setText("Back");

        searchBtn.setBackground(new java.awt.Color(255, 229, 229));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-interface-symbol.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Rollnumber:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("C2109I4533");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(searchBtn)
                .addGap(171, 171, 171)
                .addComponent(firstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previousBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextBtn)
                    .addComponent(pageSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousBtn)
                    .addComponent(firstBtn)
                    .addComponent(lastBtn)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }

    @Override
    protected void afterInitComponents() {
        super.afterInitComponents();

        jTable1.setModel(markTableModel);
        changeTableModelData(markService.getByStudentId(studentData.getId()));
        searchInput.setText("");
        jLabel3.setText(studentData.getRoll_number());
    }

    @Override
    protected void handleEvent() {
        jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new org.sem.students.views.EditPage(getContext()));
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new EditPage(getContext()));
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = jTable1.getSelectedRow();
                    Long id = (Long) jTable1.getValueAt(row, 0);

                    if (id != null) {
                        Mark mark = markDAO.get(id).orElseThrow(() -> new RuntimeException("Mark not found! Please try again!"));
                        getContext().getSession().setData("mark", mark);
                        Redirect.target(new EditPage(getContext()));
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
                        Mark mark = markDAO.get(id).orElseThrow(() -> new RuntimeException("Mark not found! Please try again!"));
                        if (showOptionPanel("Do you want delete mark " + mark.getId(), "Delete alert!")) {
                            markDAO.delete(mark);
                            Redirect.target(new EditPage(getContext()));
                        }
                    }
                } catch (Exception ex) {
                    getContext().getSession().setData("message", ex.getCause().getMessage());
                    showMessage();
                }
            }
        });


        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = searchInput.getText();

                List<Mark> marks = markDAO.searchByNameAndStudent(searchValue, studentData);
                changeTableModelData(marks);
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
                Integer totalPage = markTableModel.getTotalPage();
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

    public void changeTableModelData(List<Mark> marks) {
        markTableModel.setPageData(marks);
        updateToolBar();
    }

    public void changePageNumber(Integer pageNumber) {
        markTableModel.setCurrentPageNumber(pageNumber);
        updateToolBar();
        pageSelect.setSelectedIndex(markTableModel.getCurrentPageNumber() - 1);
    }

    private void updateToolBar() {
        Integer length = markTableModel.getTotalPage();
        String[] pageNumbers = new String[length];
        for (int i = 1; i <= length; ++i) {
            pageNumbers[i - 1] = String.valueOf(i);
        }

        pageSelect.setModel(new javax.swing.DefaultComboBoxModel<>(pageNumbers));
        lastBtn.setEnabled(!markTableModel.getLast());
        firstBtn.setEnabled(!markTableModel.getFirst());

        nextBtn.setEnabled(!markTableModel.getLast());
        previousBtn.setEnabled(!markTableModel.getFirst());
    }
}
