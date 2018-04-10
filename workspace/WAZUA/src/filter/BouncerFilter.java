package filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bouncer.Bouncer;

public class BouncerFilter implements javax.servlet.Filter {
	
	private static ServletContext context;
	private static String contextPath;
	private static String doorView;
	
	public void BouncerFilterInit(ServletContext context, String doorView) {
		BouncerFilter.context = context;
		BouncerFilter.contextPath = context.getContextPath();
		BouncerFilter.doorView = doorView;
	}
	
	@Override
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		
		Bouncer bouncer = (Bouncer) context.getAttribute("bouncer");
		if(bouncer.check((HttpServletRequest)request, (HttpServletResponse)response) ) {
			 request.getRequestDispatcher(((HttpServletRequest) request).getServletPath()).forward(request, response);
		} else {
			try {
				((HttpServletResponse) response).sendRedirect(contextPath+doorView);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
