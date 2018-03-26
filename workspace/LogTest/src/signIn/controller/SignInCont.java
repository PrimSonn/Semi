package signIn.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bouncer.Bouncer;

@WebServlet("/Door")
public class SignInCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Bouncer bouncer;
	
    public SignInCont() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		//==================================================================================================================
		System.out.println(request.getContextPath());//------------------------contextPath test!!
		// http://localhost:8001/LogTest/img/Hydrangeas.jpg  --> jpg mapping on this setting
		
//		File file = new File("./");
//		System.out.println("file root dir: " + file);//build file loc test
//		System.out.println("AbsolutePath of root dir: "+file.getAbsolutePath());
//		for(File f : file.listFiles()) {
//			System.out.println("listFile: "+f);
//			System.out.println(f.getAbsolutePath());
//		}
		
		System.out.println(this.getServletContext().getRealPath("/"));// this returns real path..
		
		
		
		//==================================================================================================================
		
		
		bouncer = new Bouncer();
		if(bouncer.check(request)) {
			response.sendRedirect("http://localhost:8001/LogTest/SignInView/MainView.jsp");
		} else {
			request.getRequestDispatcher("/SignInView/DoorView.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
