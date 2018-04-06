package listener;


import java.io.File;
import java.util.Stack;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bouncer.Bouncer;
import moviePage.dao.Gatherer;
import moviePage.dto.Packer;
import moviePage.func.Func;
import moviePage.mainCont.MoreComments;

public class WazuaListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		
		context.setRequestCharacterEncoding("utf-8");
		context.setResponseCharacterEncoding("utf-8");
		
		Bouncer bouncer = new Bouncer(context.getInitParameter("DoorView"),context.getContextPath(),context.getInitParameter("sessionCheckAttr"));
		context.setAttribute("bouncer", bouncer);
		context.setAttribute("RealPath", context.getRealPath("/"));
		
		String maxScore = context.getInitParameter("MaxScore");
		Func func = new Func();
		if(!func.isNumber(maxScore)) {
			System.out.println("Wrong Number format on MaxScore!!!!!!!");
			System.out.println("Setting MaxScore to: 5");
			context.setInitParameter("MaxScore", "5");
		}
		
		int commNum;
		try {
			String commentNum=context.getInitParameter("commentNum");
			if(func.isInt(commentNum)) {
				commNum = Integer.parseInt(commentNum);
			}else {
				System.err.println("CommNum Number format exception! set to: 3 for now");
				commNum = 3;
			}
		}catch(NumberFormatException Nooo) {
			System.err.println("CommNum Number format exception! set to: 3 for now");
			commNum = 3;
		}
		
		Gatherer get = new Gatherer();
		get.init(context.getInitParameter("OracleUser"), context.getInitParameter("OraclePW"), commNum);
		
		
		int pageCommNum;
		try {
			String stPageCommNum = context.getInitParameter("pageCommNum");
			if(func.isInt(stPageCommNum)) {
				pageCommNum = Integer.parseInt(stPageCommNum);
			}else {
				System.err.println("PageCommNum Number format exception! set to: 5 for now");
				pageCommNum=5;
			}
		}catch(NumberFormatException Nooo) {
			System.err.println("PageCommNum Number format exception! set to: 5 for now");
			pageCommNum=5;
		}
		MoreComments moreComm = new MoreComments();
		moreComm.initMoreComments(pageCommNum);
		
		int pageAmount;
		try {
			String stPageAmount = context.getInitParameter("pageAmount");
			if(func.isInt(stPageAmount)) {
				pageAmount = Integer.parseInt(stPageAmount);
				if(pageAmount<0) {
					System.err.println("PageAmount should be bigger than 0! set to: 8 for now");
					pageAmount=8;
				}
			}else {
				System.err.println("pageAmount Number format exception! set to: 8 for now");
				pageAmount=8;
			}
		}catch(NumberFormatException n) {
			System.err.println("pageAmount Number format exception! set to: 8 for now");
			pageAmount=8;
		}
		context.setAttribute("pageAmount", pageAmount);
		
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
		
//		Enumeration<String> names = context.getAttributeNames();//--------------below lines are test lines
//		while(names.hasMoreElements()) {
//			String name = names.nextElement();
//			System.out.println(context.getAttribute(name));
//			System.out.println(name+": "+context.getAttribute(name));
//		}
		
	}
	
	
	
}
