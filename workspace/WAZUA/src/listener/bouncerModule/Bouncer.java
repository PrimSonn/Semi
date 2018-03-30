package listener.bouncerModule;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bouncer {
	
	private static final String DOORPAGE = "http://localhost:8001/WAZUA/DOOR";
	
	public void check(HttpServletRequest request, HttpServletResponse response){
		if(request.getSession().getAttribute("id")==null) {
			try {
				response.sendRedirect(DOORPAGE);
			} catch (IOException e) {
				e.printStackTrace();
			};
		}//if ends
	}//check method ends
}
