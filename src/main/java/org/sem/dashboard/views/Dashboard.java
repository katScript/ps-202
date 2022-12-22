package org.sem.dashboard.views;

import org.sem.context.Context;
import org.sem.context.Redirect;
import org.sem.helper.ImageHelper;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends ViewPanel {
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JLabel jLabel2;
    private JPanel main;

    public ImageHelper imageHelper;

    public Dashboard(Context context) {
        super(context, "Management / Dashboard");
    }

    @Override
    protected void beforeInitComponents() {
        imageHelper = new ImageHelper();
    }

    @Override
    protected void initComponents() {
        main = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jLabel2 = new JLabel();

        main.setPreferredSize(new Dimension(584, 374));

        jButton2.setBackground(new Color(255, 255, 204));
        jButton2.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setIcon(new ImageIcon(imageHelper.getImage("/icons/steward.png"))); // NOI18N
        jButton2.setText("Staff");
        jButton2.setPreferredSize(new Dimension(134, 39));

        jButton3.setBackground(new Color(255, 255, 204));
        jButton3.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setIcon(new ImageIcon(imageHelper.getImage("/icons/seminar.png"))); // NOI18N
        jButton3.setText("Class");

        jButton4.setBackground(new Color(255, 255, 204));
        jButton4.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setIcon(new ImageIcon(imageHelper.getImage("/icons/checklist.png"))); // NOI18N
        jButton4.setText("Subject");

        jButton5.setBackground(new Color(255, 255, 204));
        jButton5.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setIcon(new ImageIcon(imageHelper.getImage("/icons/graduated.png"))); // NOI18N
        jButton5.setText("Student");

        jLabel2.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setIcon(new ImageIcon(imageHelper.getImage("/icons/settings.png"))); // NOI18N
        jLabel2.setText("MANAGEMENT SYSTEM");

        GroupLayout mainLayout = new GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(122, 122, 122))
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2)
                                .addGap(49, 49, 49)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(49, Short.MAX_VALUE))
        );
    }

    @Override
    protected void handleEvent() {
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new org.sem.classes.views.ListingPage(getContext()));
            }
        });
        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new org.sem.students.views.ListingPage(getContext()));
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new org.sem.subjects.views.ListingPage(getContext()));
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Redirect.target(new org.sem.staffs.views.ListingPage(getContext()));
            }
        });
    }

    @Override
    public JPanel getMainLayer() {
        return main;
    }
}
