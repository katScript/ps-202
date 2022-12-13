package org.sem.authenticate.views;

import org.sem.context.Context;
import org.sem.view.ViewPanel;

import javax.swing.*;

public class RegisterPage extends ViewPanel {
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JPanel main;

    public RegisterPage(Context context) {
        super(context, "Management / Register");
    }

    @Override
    protected void beforeInitComponents() {

    }

    @Override
    protected void initComponents() {
        main = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jLabel4 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jLabel5 = new JLabel();
        jPasswordField2 = new JPasswordField();
        jButton1 = new JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("STUDENT MANAGEMENT SYSTEM");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("User name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Password");

        jPasswordField1.setText("12345678");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Comfirm password");

        jPasswordField2.setText("12345678");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Register");

        GroupLayout mainLayout = new GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                        .addComponent(jPasswordField1)
                                                        .addComponent(jPasswordField2)))
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addGap(159, 159, 159)
                                                .addComponent(jButton1)))
                                .addGap(45, 45, 45))
                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jPasswordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
    }

    @Override
    protected void handleEvent() {

    }

    @Override
    public JPanel getMainLayer() {
        return main;
    }
}
