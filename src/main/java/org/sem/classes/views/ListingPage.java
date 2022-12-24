package org.sem.classes.views;

import javax.swing.*;

import org.sem.classes.models.Class;
import org.sem.classes.models.ClassDAO;
import org.sem.classes.models.ClassTableModel;
import org.sem.classes.service.ClassService;
import org.sem.context.Context;
import org.sem.context.Redirect;
import org.sem.dashboard.views.Dashboard;
import org.sem.students.models.Student;
import org.sem.view.ViewPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListingPage extends ViewPanel {
    private javax.swing.JButton firstBtn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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

    public ClassDAO classDAO;
    public ClassService classService;
    public ClassTableModel classTableModel;

    public ListingPage(Context context) {
        super(context, "Class");
    }

    public JPanel getMainLayer() {
        return main;
    }

    @Override
    protected void beforeInitComponents() {
        classDAO = new ClassDAO();
        classService = new ClassService();
        classTableModel = new ClassTableModel();
        getContext().getSession().setData("class", null);
    }

    @Override
    protected void initComponents() {
        main = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lastBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        pageSelect = new javax.swing.JComboBox<>();
        previousBtn = new javax.swing.JButton();
        firstBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jButton10.setBackground(new java.awt.Color(255, 255, 204));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jButton10.setText("Back");
        jButton10.setPreferredSize(new java.awt.Dimension(100, 39));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("CLASS MANAGEMENT SYSTEM");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "ID", "Class"
                }
        ) {
            java.lang.Class[] types = new java.lang.Class[] {
                    java.lang.Long.class, java.lang.String.class
            };

            public java.lang.Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lastBtn.setBackground(new java.awt.Color(204, 204, 255));
        lastBtn.setText("Last");

        nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/next.png"))); // NOI18N

        pageSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        pageSelect.setPreferredSize(new java.awt.Dimension(72, 23));

        previousBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/left-chevron.png"))); // NOI18N
        previousBtn.setPreferredSize(new java.awt.Dimension(16, 23));

        firstBtn.setBackground(new java.awt.Color(204, 204, 255));
        firstBtn.setText("First");
        firstBtn.setPreferredSize(new java.awt.Dimension(70, 23));

        searchInput.setText("Search...");
        searchInput.setMinimumSize(new java.awt.Dimension(64, 23));
        searchInput.setPreferredSize(new java.awt.Dimension(64, 23));

        searchBtn.setBackground(new java.awt.Color(255, 229, 229));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-interface-symbol.png"))); // NOI18N

        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        jButton7.setText("Delete");
        jButton7.setPreferredSize(new java.awt.Dimension(94, 36));

        jButton8.setBackground(new java.awt.Color(255, 204, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton8.setText("Add new");

        jButton6.setBackground(new java.awt.Color(255, 204, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editing.png"))); // NOI18N
        jButton6.setText("Update");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(searchBtn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(firstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(previousBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(pageSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButton8)
                                .addGap(50, 50, 50)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jButton6)
                                .addGap(35, 35, 35))
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pageSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(previousBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lastBtn)
                                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
    }

    @Override
    protected void afterInitComponents() {
        super.afterInitComponents();

        jTable1.setModel(classTableModel);
        changeTableModelData(classDAO.getAll());
        searchInput.setText("");
    }

    protected void handleEvent() {
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = jTable1.getSelectedRow();
                    Long id = (Long) jTable1.getValueAt(row, 0);
                    Class aClass = classDAO.get(id).orElseThrow(() -> new RuntimeException("Class not found!"));

                    if (aClass != null) {
                        getContext().getSession().setData("class", aClass);
                        Redirect.target(new EditPage(getContext()));
                    }

                } catch (Exception ex) {
                    getContext().getSession().setData("message", ex.getCause().getMessage());
                    showMessage();
                }
            }
        });
        jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = jTable1.getSelectedRow();
                    Long id = (Long) jTable1.getValueAt(row, 0);

                    if (id != null) {
                        classService.deleteClass(id);
                        ListingPage page = new ListingPage(getContext());
                        getContext().changeLayer(page.getMainLayer());
                    }

                } catch (Exception ex) {
                    getContext().getSession().setData("message", ex.getCause().getMessage());
                    showMessage();
                }
            }
        });
        jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new CreateNewPage(getContext()));
            }
        });

        jButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new Dashboard(getContext()));
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = searchInput.getText();

                List<Class> classes = classDAO.searchByName(searchValue);
                changeTableModelData(classes);
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
                Integer totalPage = classTableModel.getTotalPage();
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

    private ClassTableModel getClassTableModel() {
        ClassTableModel classTableModel = new ClassTableModel();
        classTableModel.setData(classDAO.getAll());
        return classTableModel;
    }

    public void changeTableModelData(List<Class> classes) {
        classTableModel.setPageData(classes);
        updateToolBar();
    }

    public void changePageNumber(Integer pageNumber) {
        classTableModel.setCurrentPageNumber(pageNumber);
        updateToolBar();
        pageSelect.setSelectedIndex(classTableModel.getCurrentPageNumber() - 1);
    }

    private void updateToolBar() {
        Integer length = classTableModel.getTotalPage();
        String[] pageNumbers = new String[length];
        for (int i = 1; i <= length; ++i) {
            pageNumbers[i - 1] = String.valueOf(i);
        }

        pageSelect.setModel(new javax.swing.DefaultComboBoxModel<>(pageNumbers));
        lastBtn.setEnabled(!classTableModel.getLast());
        firstBtn.setEnabled(!classTableModel.getFirst());

        nextBtn.setEnabled(!classTableModel.getLast());
        previousBtn.setEnabled(!classTableModel.getFirst());
    }
}
