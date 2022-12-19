package org.sem.subjects.views;

import org.sem.classes.views.ListingPage;
import org.sem.context.Context;
import org.sem.context.Session;
import org.sem.subjects.services.SubjectService;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPage extends ViewPanel {
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private JPanel main;

    public SubjectService subjectService;

    public EditPage(Context context) {
        super(context, "Subject");
    }

    @Override
    protected void beforeInitComponents() {
        subjectService = new SubjectService();
    }

    @Override
    protected void initComponents() {
        main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        getContext().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUBJECT MANAGEMENT SYSTEM");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Subject name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Code");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Total hour");

        jButton1.setBackground(new java.awt.Color(0, 51, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 204));
        jButton1.setText("Update");
        jButton1.setPreferredSize(new java.awt.Dimension(99, 39));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sem/icons/back.png"))); // NOI18N
        jButton2.setText("Back");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(mainLayout.createSequentialGroup()
                                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(mainLayout.createSequentialGroup()
                                                                        .addGap(50, 50, 50)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jTextField3)
                                                                .addComponent(jTextField4)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(jButton2)))
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );
    }

    @Override
    protected void handleEvent() {
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = getContext().getSession();
                subjectService.save(
                        session.getData("id") == null ? null : Long.parseLong((String) session.getData("id")),
                        jTextField2.getText(),
                        jTextField3.getText(),
                        Double.parseDouble(jTextField4.getText())
                );

                getContext().getSession().setData("message", "Save subject successfully!");
                ListingPage page = new ListingPage(getContext());
                getContext().changeLayer(page.getMainLayer());
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListingPage page = new ListingPage(getContext());
                getContext().changeLayer(page.getMainLayer());
            }
        });
    }

    @Override
    public JPanel getMainLayer() {
        return main;
    }
}
