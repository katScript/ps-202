package org.sem;

import org.sem.authenticate.views.LoginPage;
import org.sem.context.Context;

public class App 
{
    public static void main(String[] args )
    {
        Context context = new Context();
        LoginPage lp = new LoginPage(context);

        context.setLayerPanel(lp.getMainLayer());
        context.setVisible(true);
    }
}
