package bouncer;

import javax.servlet.http.HttpServletRequest;

public class Bouncer {
	
	public boolean check(HttpServletRequest request) {
		if(request.getSession().getAttribute("stamp")==Integer.valueOf(1)) return true;
		return false;
	}
	public void stamp(HttpServletRequest request) {
		request.getSession().setAttribute("stamp", Integer.valueOf(1));
	}
}
