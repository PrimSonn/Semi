package signIn.controller;

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
	private boolean isLogged;
	
    public SignInCont() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bouncer = new Bouncer();
		isLogged = bouncer.check(request);//----login check
		response.setCharacterEncoding("utf-8");
		
		if(isLogged) {
			response.sendRedirect("http://localhost:8001/LogTest/SignInView/MainView.jsp");
		}
		request.getRequestDispatcher("/SignInView/DoorView.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
