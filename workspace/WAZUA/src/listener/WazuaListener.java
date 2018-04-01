package listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bouncer.Bouncer;
import moviePage.dao.Gatherer;
import moviePage.dto.Packer;

public class WazuaListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		
		Bouncer bouncer = new Bouncer(context.getInitParameter("DoorView"));
		context.setAttribute("bouncer", bouncer);
		context.setAttribute("RealPath", sce.getServletContext().getRealPath("/"));
		
		Gatherer get = new Gatherer();
		get.init(context.getInitParameter("OracleUser"),context.getInitParameter("OraclePW"));
		
		Packer pack = new Packer();
		pack.init(context.getInitParameter("Address"));
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
