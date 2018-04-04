package driver.sign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sign/Up")
public class SignUpCont extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/SignView/SignUpView.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		if(""==email||email==null||26<email.length()
				||""==pw||pw==null||26<pw.length()
				||""==pw2||pw2==null||!pw2.equals(pw)
				||""==name||name==null||26<name.length()
				||""==birth||birth==null||8>birth.length()
				) {
			request.getRequestDispatcher(this.getInitParameter("SignUpView")).forward(request, response);
		} else {
			request.getRequestDispatcher(this.getInitParameter("SignUpView")).forward(request, response);//--stub
		}
	}	

}
