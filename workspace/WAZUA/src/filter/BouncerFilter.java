package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Bouncer implements javax.servlet.Filter{
	
	public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain filterChain) throws IOException, ServletException {
		
		filterChain.doFilter(request, reponse);
	}

}
