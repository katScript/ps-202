/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sem.staff.views;

import com.intellij.uiDesigner.core.GridLayoutManager;
import org.sem.view.ViewPanel;

import javax.swing.*;
import java.awt.*;
import org.sem.controller.Context;
import org.sem.staff.models.StaffDAO;
import org.sem.staff.models.StaffTableModel;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
/**
 *
 * @author Win 10 Pro x64
 */
public class ListingPage extends ViewPanel{
 private JPanel main;
 
 private JTable StaffTable;
 private JScrollPane ScrollPaneTable;
 
  private StaffDAO staffDAO;
  public ListingPage(Context context) {
        super(context);
        getContext().setPageTitle("Staff listing page");

        // event of button point to other page

        // event of button run functional as edit, update, delete

    }
  
  
    @Override

   
    protected void beforeInitComponents() {
  staffDAO = new StaffDAO();    }

    @Override
    protected void initComponents() {
 main = new JPanel();
        main.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
     Component scrollPaneTable = new JScrollPane();
        main.add(scrollPaneTable, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        StaffTable = new JTable();

      
    }

    @Override
      public JPanel getMainLayer() {
        return main;
    }

   
    
    
}
