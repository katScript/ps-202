package org.sem;

import org.sem.authenticate.views.LoginPage;
import org.sem.context.Context;
import org.sem.dashboard.views.Dashboard;

public class App 
{
    public static void main(String[] args )
    {
        Context context = new Context();
        new Dashboard(context);

        context.setVisible(true);
    }
}
