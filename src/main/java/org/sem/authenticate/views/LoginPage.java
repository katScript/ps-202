package org.sem.authenticate.views;

import org.sem.authenticate.models.User;
import org.sem.authenticate.services.UserService;
import org.sem.context.Context;
import org.sem.context.Redirect;
import org.sem.dashboard.views.Dashboard;
import org.sem.helper.ImageHelper;
import org.sem.staffs.models.Staff;
import org.sem.staffs.models.StaffDAO;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends ViewPanel {
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
    private JPanel main;

    public ImageHelper imageHelper;
    public UserService userService;
    public StaffDAO staffDAO;

    public LoginPage(Context context) {
        super(context, "Management / Login");
    }

    public JPanel getMainLayer() {
        return main;
    }

    @Override
    protected void beforeInitComponents() {
        imageHelper = new ImageHelper();
        userService = new UserService();
        staffDAO = new StaffDAO();
    }

    @Override
    protected void initComponents() {
        main = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        jLabel1.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("STUDENT MANAGEMENT SYSTEM");

        jLabel2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setIcon(new ImageIcon(imageHelper.getImage("/icons/user.png"))); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setIcon(new ImageIcon(imageHelper.getImage("/icons/lock.png"))); // NOI18N
        jLabel3.setText("Password");

        jTextField1.setText("");
        jPasswordField1.setText("");

        jButton1.setBackground(new Color(255, 204, 204));
        jButton1.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Login");

        jButton2.setBackground(new Color(255, 255, 204));
        jButton2.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Register");
        jButton2.setVisible(false);

        GroupLayout mainLayout = new GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                                        .addComponent(jPasswordField1)))
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addGap(193, 193, 193)
                                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3))
                                .addGap(32, 32, 32)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(13, Short.MAX_VALUE))
        );
    }

    protected void handleEvent() {
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = userService.login(
                            jTextField1.getText(),
                            jPasswordField1.getText()
                    ).orElseThrow(() -> new RuntimeException("Username or password not correct!"));

                    Staff staff = staffDAO.getByUser(user).orElseThrow(() -> new RuntimeException("Staff data not found!"));

                    getContext().getSession().setData("user", user);
                    getContext().getSession().setData("user_information", staff);

                    getContext().setIsValidateUser(true);
                    Redirect.target(new Dashboard(getContext()));
                } catch (Exception ex) {
                    getContext().getSession().setData("message", ex.getMessage());
                    showMessage();
                }

            }
        });
    }
}
