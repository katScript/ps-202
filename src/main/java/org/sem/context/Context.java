package org.sem.context;

import javax.swing.*;
import java.awt.*;

public class Context extends JFrame {
    private JLayeredPane mainLayer;
    private Session session;

    private Boolean isValidateUser = true;

    public static final Integer WIDTH = 1200;
    public static final Integer HEIGHT = 675;
    public static final Integer MAX_WIDTH = 1200;
    public static final Integer MAX_HEIGHT = 675;
    public static final Integer MIN_WIDTH = 500;
    public static final Integer MIN_HEIGHT = 281;

    public Context() {
        this.session = new Session();

        initComponents();
        setContentPane(mainLayer);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    private void initComponents() {
        mainLayer = new JLayeredPane();

        mainLayer.setMaximumSize(new Dimension(Context.MAX_WIDTH, Context.MAX_HEIGHT));
        mainLayer.setMinimumSize(new Dimension(Context.MIN_WIDTH, Context.MIN_HEIGHT));
        mainLayer.setPreferredSize(new Dimension(Context.WIDTH, Context.HEIGHT));
    }

    public void setLayerPanel(JPanel panel) {
        if (panel == null)
            return;

        mainLayer.add(panel, 0);
    }

    public void changeLayer(JPanel panel) {
        if (panel == null)
            return;

        if (mainLayer.getComponentCount() > 0)
            mainLayer.remove(0);

        mainLayer.add(panel, 0);
    }

    public void setPageTitle(String title) {
        setTitle(title);
    }

    public void setIsValidateUser(Boolean isValidateUser) {
        this.isValidateUser = isValidateUser;
    }

    public Boolean isValidateUser() {
        return isValidateUser;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
