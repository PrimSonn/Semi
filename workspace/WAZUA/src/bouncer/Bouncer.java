package bouncer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Bouncer {
	
	private static String DoorView;//DoorView address
	
	public Bouncer(String DoorView) {
		Bouncer.DoorView = DoorView;
	}
	
	public boolean check(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			if(session.getAttribute("id")!=null) {
				return true;
			}
		}
		try {
			request.setCharacterEncoding("utf-8");
			request.getRequestDispatcher(DoorView).forward(request, response);
			return false;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
