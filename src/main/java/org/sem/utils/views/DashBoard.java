package org.sem.utils.views;

import org.sem.context.Context;
import org.sem.view.ViewPanel;

import javax.swing.*;

public class DashBoard extends ViewPanel {
    public DashBoard(Context context) {
        super(context);
        getContext().setPageTitle("Dash board");


    }

    @Override
    protected void beforeInitComponents() {

    }

    @Override
    protected void initComponents() {

    }

    @Override
    public JPanel getMainLayer() {
        return null;
    }
}
