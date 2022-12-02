package org.sem.classes.views;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.sem.controller.Context;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPage extends ViewPanel {
    private JPanel main;
    private JButton listing;

    public EditPage (Context context) {
        super(context);
        this.getContext().setPageTitle("Class edit page");
        initComponents();

        listing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListingPage listingPage = new ListingPage(getContext());
                getContext().changeLayer(listingPage.getMainLayer());
            }
        });
    }

    public JPanel getMainLayer() {
        return main;
    }

    protected void initComponents() {
        main = new JPanel();

        main.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        main.setMinimumSize(new Dimension(500, 281));
        main.setPreferredSize(new Dimension(800, 450));
        listing = new JButton();
        listing.setText("Listing");
        main.add(listing, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        main.setBounds(0,0,800,450);
    }
}
