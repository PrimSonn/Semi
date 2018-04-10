package driver.sign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sign/In")
public class SignInCont extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(this.getServletContext().getInitParameter("SignInView")).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//---------------test driver..need proper signin
		String id = request.getParameter("id");
		request.getSession().setAttribute("id", id);
		response.sendRedirect(this.getServletContext().getContextPath()+this.getServletContext().getInitParameter("Main"));
	}

}
