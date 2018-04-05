package listener;


import java.io.File;
import java.util.Stack;

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
		
		context.setRequestCharacterEncoding("utf-8");
		context.setResponseCharacterEncoding("utf-8");
		
		Bouncer bouncer = new Bouncer(context.getInitParameter("DoorView"),context.getContextPath());
		context.setAttribute("bouncer", bouncer);
		context.setAttribute("RealPath", context.getRealPath("/"));
		
		Gatherer get = new Gatherer();
		get.init(context.getInitParameter("OracleUser"),context.getInitParameter("OraclePW"));
		
		Packer pack = new Packer();
		pack.init(context.getInitParameter("Address"));
		
		nullThumbInit(sce,context.getRealPath("/"),context.getContextPath());
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	public void nullThumbInit(ServletContextEvent sce, String realPath, String contextPath) {
		Stack<File> stack = new Stack<File>();
		String mask = realPath+"\\"+"Imgs\\"+"Null"+"\\";
		File file = new File(mask);
		int cutter = realPath.length()-1;
		ServletContext context = sce.getServletContext();
		String ADDRESS = context.getInitParameter("Address");
		
		if(file.isDirectory()) {
			for(File f : file.listFiles()) stack.push(f);
			for(;;) {
				if(file.isFile()) {
					context.setAttribute( "Null"+file.getAbsoluteFile().getParentFile().getName()
							, ADDRESS+contextPath+file.toString().substring(cutter).replace('\\', '/') );
				}else if(file.isDirectory()) {
					for(File f : file.listFiles()) stack.push(f);
				}
				if(stack.isEmpty())break;
				file=stack.pop();
			}//file search for ends
		}//file check if ends
		
//		Enumeration<String> names = context.getAttributeNames();
//		while(names.hasMoreElements()) {
//			String name = names.nextElement();
//			System.out.println(context.getAttribute(name));
//			System.out.println(name+": "+context.getAttribute(name));
//		}
		
	}
	
	
	
}
