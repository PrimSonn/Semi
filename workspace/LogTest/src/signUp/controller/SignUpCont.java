package signUp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signUp.dao.SignUpDao;
import signUp.dto.Account;

@WebServlet("/SignUp")
public class SignUpCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/SignInView/SignUpView.jsp").forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		
		if(""==id||id==null||""==pw||pw==null||""==pw2||pw2==null) {
			response.sendRedirect("http://localhost:8001/LogTest/SignUp");
		}
		
		Account account = new Account();
		account.setId(id);
		account.setPw(pw);
		account.setPw2(pw2);
		SignUpDao sign = new SignUpDao();
		if(sign.signUp(account)) {
			response.sendRedirect("http://localhost:8001/LogTest/LogInMain");
		}
		response.sendRedirect("http://localhost:8001/LogTest/SignUp");
	}

}
