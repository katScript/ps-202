package org.sem.classes.component;

import org.sem.classes.models.Class;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboboxRender extends JLabel implements ListCellRenderer {

    public ComboboxRender() {
//        setOpaque(true);
//        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
//        setBackground(Color.BLUE);
//        setForeground(Color.YELLOW);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        Class aClass = (Class) value;
        setText(aClass.getClassName());
        return this;
    }

}