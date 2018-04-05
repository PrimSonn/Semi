package bouncer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Bouncer {
	
	private static String DoorView;//DoorViewView address
	private static String ContextPath;
	
	public Bouncer(String DoorViewView,String ContextPath) {
		Bouncer.DoorView = DoorViewView;
		Bouncer.ContextPath = ContextPath;
	}
	
	@SuppressWarnings("finally")
	public boolean check(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			if(session.getAttribute("id")!=null) {
				return true;
			}
		}
		try {
			response.sendRedirect(ContextPath+DoorView);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			return false;
		}
		
	}
}
