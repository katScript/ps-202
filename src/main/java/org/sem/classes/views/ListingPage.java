package org.sem.classes.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.intellij.uiDesigner.core.*;
import org.sem.context.Context;
import org.sem.view.ViewPanel;

public class ListingPage extends ViewPanel {
    private JPanel main;
    private JButton edit;

    public ListingPage(Context context) {
        super(context, "Class listing page");
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
        edit.setText("Edit");
        main.add(edit, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    protected void handleEvent() {
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditPage editPage = new EditPage(getContext());
                getContext().changeLayer(editPage.getMainLayer());
            }
        });
    }
}
