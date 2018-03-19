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
	
    public SignInCont() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
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
