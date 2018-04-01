package bouncer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bouncer {
	
	private static String DoorView;//DoorView address
	
	public Bouncer(String DoorView) {
		Bouncer.DoorView = DoorView;
	}
	
	public boolean check(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("id")==null) {
			try {
				request.setCharacterEncoding("utf-8");
				request.getRequestDispatcher(DoorView).forward(request, response);
				return false;
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
