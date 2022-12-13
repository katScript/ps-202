package org.sem.students.views;

import org.sem.context.Context;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPage extends ViewPanel {
    private JButton jButton1;
    private JComboBox<String> jComboBox2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JPanel main;

    public EditPage(Context context) {
        super(context, "Student");
    }

    @Override
    protected void beforeInitComponents() {

    }

    @Override
    protected void initComponents() {
        main = new JPanel();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jTextField8 = new JTextField();
        jComboBox2 = new JComboBox<>();
        jButton1 = new JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("STUDENT MANAGEMENT SYSTEM");

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Full name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("DOB");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Gender");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Phone");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Address");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Roll number");

        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Male", "Female"}));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Update");

        GroupLayout mainLayout = new GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainLayout.createSequentialGroup().addGap(31, 31, 31).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup().addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE).addContainerGap()).addGroup(mainLayout.createSequentialGroup().addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE).addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE).addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE).addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE).addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE).addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)).addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(jTextField5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE).addComponent(jTextField4, GroupLayout.Alignment.LEADING).addComponent(jTextField8, GroupLayout.Alignment.LEADING).addComponent(jTextField7, GroupLayout.Alignment.LEADING).addComponent(jTextField2, GroupLayout.Alignment.LEADING).addComponent(jComboBox2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jTextField1, GroupLayout.Alignment.LEADING).addComponent(jTextField6)).addGap(0, 0, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE).addGap(25, 25, 25)))));
        mainLayout.setVerticalGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(jLabel1).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabel2)).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabel9)).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabel3)).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabel6)).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabel7)).addGap(18, 18, 18).addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabel8)).addGap(18, 18, 18).addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addContainerGap(15, Short.MAX_VALUE)));
    }

    @Override
    protected void handleEvent() {
        jButton1.addActionListener(new ActionListener() {
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
