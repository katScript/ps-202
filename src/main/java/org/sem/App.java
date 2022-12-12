package org.sem;

import org.sem.authenticate.views.LoginPage;
import org.sem.context.Context;

public class App 
{
    public static void main(String[] args )
    {
        Context context = new Context();
        context.setIsValidateUser(false);
        LoginPage page = new LoginPage(context);

        context.setLayerPanel(page.getMainLayer());
        context.setVisible(true);
    }
}
