package org.sem.authenticate.views;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.sem.context.Context;
import org.sem.students.views.ListingPage;
import org.sem.subjects.views.EditPage;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends ViewPanel {
    private JPanel main;
    private JButton edit;

    public LoginPage(Context context) {
        super(context, "Login page");
    }

    public JPanel getMainLayer() {
        return main;
    }

    @Override
    protected void beforeInitComponents() {}

    @Override
    protected void initComponents() {
        main = new JPanel();

        main.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        edit = new JButton();
        edit.setText("Login");
        main.add(edit, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    protected void handleEvent() {
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Context context = getContext();
                context.setIsValidateUser(true);
                context.getSession().setData("user", true);
                ListingPage page = new ListingPage(context);
                context.changeLayer(page.getMainLayer());
            }
        });
    }
}
