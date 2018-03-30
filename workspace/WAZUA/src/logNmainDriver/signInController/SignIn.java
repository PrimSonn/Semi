package logNmainDriver.signInController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/logNmainDriver_VIEW/SignInView.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		this.getServletContext().getAttribute("Bouncer");
		
		Account account = new Account();
		account.setId(id);
		account.setPw(pw);
		SignUpDao sign = new SignUpDao();
		
		if(""==id||id==null||""==pw||pw==null) {
			response.sendRedirect("http://localhost:8001/WAZUA/SignIn");
		}else if(sign.signIn(account)) {
			Bouncer bouncer = new Bouncer();
			bouncer.stamp(request);
			request.getRequestDispatcher("/Door").forward(request, response);
		} else {
			response.sendRedirect("http://localhost:8001/WAZUA/SignIn");
		}
	}
}
