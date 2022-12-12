package org.sem.subjects.views;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.sem.context.Context;
import org.sem.subjects.models.SubjectDAO;
import org.sem.subjects.models.SubjectTableModel;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.*;

// 1. extends class ViewPanel
public class ListingPage extends ViewPanel {
    //============ critical value ===========
    private JPanel main;
    //=======================================
    private JTable subjectTable;
    private JScrollPane scrollPaneTable;

    // data access variable
    private SubjectDAO subjectDAO;

    // 2. constructor has to be have Context class
    public ListingPage(Context context) {
        super(context, "Subjects listing page");
        // event of button point to other page
        // event of button run functional as edit, update, delete
    }

    @Override
    protected void beforeInitComponents() {
        subjectDAO = new SubjectDAO();
    }

    @Override
    protected void initComponents() {
        main = new JPanel();
        main.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        scrollPaneTable = new JScrollPane();
        main.add(scrollPaneTable, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        subjectTable = new JTable();

        SubjectTableModel stm = new SubjectTableModel();
        stm.setData(subjectDAO.getAll());
        subjectTable.setModel(stm);

        scrollPaneTable.setViewportView(subjectTable);
    }

    @Override
    protected void handleEvent() {

    }

    @Override
    public JPanel getMainLayer() {
        return main;
    }
}
