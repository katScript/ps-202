package org.sem;

import org.sem.classes.views.ListingPage;
import org.sem.controller.Context;

public class App 
{
    public static void main(String[] args )
    {
        Context controller = new Context();
        ListingPage lp = new ListingPage(controller);

        controller.setLayerPanel(lp.getMainLayer());
        controller.setVisible(true);
    }
}
