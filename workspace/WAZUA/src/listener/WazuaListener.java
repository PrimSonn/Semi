package listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bouncer.Bouncer;

public class WazuaListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		Bouncer bouncer = new Bouncer(context.getInitParameter("DoorView"));
		context.setAttribute("bouncer", bouncer);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
