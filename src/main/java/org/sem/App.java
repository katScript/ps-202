package org.sem;

import org.sem.classes.views.ListingPage;
import org.sem.controller.Context;

public class App 
{
    public static void main(String[] args )
    {
        Context context = new Context();
        ListingPage lp = new ListingPage(context);

        context.setLayerPanel(lp.getMainLayer());
        context.setVisible(true);
    }
}
