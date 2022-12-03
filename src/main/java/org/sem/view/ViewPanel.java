package org.sem.view;

import org.sem.controller.Context;

import javax.swing.*;

public abstract class ViewPanel {
    private Context context;

    public ViewPanel(Context context) {
        this.context = context;
        beforeInitComponents();
        initComponents();
    }

    protected abstract void beforeInitComponents();

    protected abstract void initComponents();

    public abstract JPanel getMainLayer();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
