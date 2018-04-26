package web.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminIntercepter extends HandlerInterceptorAdapter{

	private static final Logger logger= LoggerFactory.getLogger(AdminIntercepter.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("intercepter: afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("Intercepter: afterConcurrentHandlingStarted");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("Intercepter: postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("Intercepter: preHande");
		logger.info(request.getRequestURI());
		
		String nick = (String) request.getSession().getAttribute("nick");
		boolean isAdmin = false;
		System.out.println("nick: "+ nick);
		
		if(nick==null) {
			logger.info("not logged in");
		}else {
			if("admin user" == nick) {
				System.out.println("equal operation success");
				isAdmin=true;
			} else if(nick.equals("admin user")) {
				System.out.println("equal method success");
				isAdmin=true;
			}
			if(nick.matches("admin user")) {
				System.out.println("matches method success");
				isAdmin=true;
			} else {
				logger.info("not admin");
			}
		}
		
		if(!isAdmin) {
			response.sendRedirect("fail");
		}
		
		return isAdmin;
	}
}
