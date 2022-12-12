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
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
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
        main = new JPanel();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jButton1 = new JButton();

        jLabel1.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new Color(0, 0, 204));
        jLabel1.setText("SUBJECT MANAGEMENT SYSTEM");

        jTextField1.setText("");

        jTextField2.setText("");

        jTextField3.setText("");

        jTextField4.setText("");

        jLabel2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Subject name");

        jLabel4.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Code");

        jLabel5.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Total hour");

        jButton1.setBackground(new Color(255, 153, 255));
        jButton1.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Update");

        GroupLayout mainLayout = new GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                                .addGap(16, 16, 16)
                                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField3)
                                                        .addComponent(jTextField4)))
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(11, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
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
                page.showMessage();
            }
        });
    }

    @Override
    public JPanel getMainLayer() {
        return main;
    }
}
