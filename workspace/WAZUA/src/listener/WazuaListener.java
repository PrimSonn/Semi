package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import listener.bouncerModule.Bouncer;


@WebListener
public class WazuaListener implements ServletContextListener {
	
    public WazuaListener() {
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
    
    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("LISTENER:conetxt initialized");//-----------------------------------------------------------testcode
    	sce.getServletContext().setAttribute("Bouncer", new Bouncer());
    	System.out.println("Bouncer created");//-----------------------------------------------------------testcode
    }
}
