package bouncer;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class Bouncer {
	
	public boolean check(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		if(request.getSession().getAttribute("stamp")==Integer.valueOf(1)) return true;
		return false;
	}
	public void stamp(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		request.getSession().setAttribute("stamp", Integer.valueOf(1));
	}
}
