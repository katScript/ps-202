package org.sem.context;

import org.sem.view.ViewPanel;

import javax.swing.*;

public class Redirect {
    public static void target(ViewPanel view) {
        Context context = view.getContext();
        JPanel main = view.getMainLayer();
        context.changeLayer(main);
    }
}
