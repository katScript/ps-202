package org.sem.view;

import org.sem.authenticate.views.LoginPage;
import org.sem.classes.views.EditPage;
import org.sem.classes.views.ListingPage;
import org.sem.context.Context;
import org.sem.context.Session;

import javax.swing.*;
import java.awt.*;

public abstract class ViewPanel {
    private Context context;

    public ViewPanel(Context context) {
        this.context = context;
        processPageContent();
    }

    public ViewPanel(Context context, String pageTitle) {
        this.context = context;
        this.context.setPageTitle(pageTitle);
        processPageContent();
    }

    private void processPageContent() {
        Session session = this.context.getSession();

        if (this.context.isValidateUser() && session.getData("user") == null) {
            this.context.setIsValidateUser(false);

            LoginPage page = new LoginPage(this.context);
            this.context.changeLayer(page.getMainLayer());
        } else {
            beforeInitComponents();
            initComponents();
            afterInitComponents();
        }
    }

    protected abstract void beforeInitComponents();

    protected abstract void initComponents();

    protected void afterInitComponents() {
        this.handleEvent();

        this.getMainLayer().setMaximumSize(new Dimension(Context.MAX_WIDTH, Context.MAX_HEIGHT));
        this.getMainLayer().setMinimumSize(new Dimension(Context.MIN_WIDTH, Context.MIN_HEIGHT));
        this.getMainLayer().setPreferredSize(new Dimension(Context.WIDTH, Context.HEIGHT));

        this.getMainLayer().setBounds(0,0, Context.WIDTH, Context.HEIGHT);
    }

    protected abstract void handleEvent();

    public abstract JPanel getMainLayer();

    public Context getContext() {
        return context;
    }

    public void showMessage() {
        String message = (String) getContext().getSession().getData("message");
        if (message != null)
            JOptionPane.showMessageDialog(getMainLayer(), message);
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
