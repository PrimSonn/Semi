package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharEncoder implements javax.servlet.Filter{
	
	private static String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
	
	public void charFilterInit(String encoding) {
		CharEncoder.encoding=encoding;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		
		if(CharEncoder.encoding!=null) {
			request.setCharacterEncoding(CharEncoder.encoding);
			response.setCharacterEncoding(CharEncoder.encoding);
		}
		
		filterChain.doFilter(request, response);
	}
	
	
}
