package web.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ForumIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		boolean islogged = false;
		if(request.getSession().getAttribute("nick")==null) {
			response.sendRedirect("failed");
		} else {
			islogged=true;
		}
		
		return islogged;
	}
}
