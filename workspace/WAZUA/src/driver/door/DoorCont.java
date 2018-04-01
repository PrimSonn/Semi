package driver.door;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bouncer.Bouncer;

@WebServlet("/Door")
public class DoorCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getSession().getAttribute("id"));
		Bouncer bouncer =  (Bouncer) this.getServletContext().getAttribute("bouncer");
		if(bouncer.check(request, response)) {
			response.sendRedirect(this.getServletContext().getContextPath()+this.getServletContext().getInitParameter("Main"));
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
