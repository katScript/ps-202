package org.sem.controller;

import javax.swing.*;
import java.awt.*;

public class Context extends JFrame {
    private JLayeredPane mainLayer;

    public Context() {
        initComponents();
        setContentPane(mainLayer);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    private void initComponents() {
        mainLayer = new JLayeredPane();
        mainLayer.setMinimumSize(new Dimension(500, 281));
        mainLayer.setPreferredSize(new Dimension(800, 450));
    }

    public void setLayerPanel(JPanel panel) {
        mainLayer.add(panel, 0);
    }

    public void changeLayer(JPanel panel) {
        mainLayer.remove(0);
        mainLayer.add(panel, 0);
    }

    public void setPageTitle(String title) {
        setTitle(title);
    }
}
