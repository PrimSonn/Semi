package bouncer;

import javax.servlet.http.HttpServletRequest;

public class Bouncer {
	
	public boolean check(HttpServletRequest request) {
		if(request.getSession().getAttribute("stamp")==null) return false;
		return true;
	}
	public void stamp(HttpServletRequest request) {
		request.getSession().setAttribute("stamp", 1);
	}
}
