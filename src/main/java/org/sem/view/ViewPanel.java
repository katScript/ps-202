package org.sem.view;

import org.sem.authenticate.views.LoginPage;
import org.sem.classes.views.EditPage;
import org.sem.classes.views.ListingPage;
import org.sem.context.Context;
import org.sem.context.Redirect;
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
        showMessage();

        if (this.context.isValidateUser() && session.getData("user") == null) {
            this.context.setIsValidateUser(false);

            Redirect.target(new LoginPage(this.context));
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

        getContext().getSession().setData("message", null);
    }

    public boolean showOptionPanel(String message, String title) {
        int result = JOptionPane.showConfirmDialog(getMainLayer(),message, title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        return result == JOptionPane.YES_OPTION;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
