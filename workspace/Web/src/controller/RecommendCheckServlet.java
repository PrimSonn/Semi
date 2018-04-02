package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Recommend;
import service.RecommendService;
import service.RecommendServiceimpl;

@WebServlet("/recommend/check.do")
public class RecommendCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecommendService service=null;
		service = new RecommendServiceimpl();
		
		String recommendId = request.getParameter("id");		
		Recommend user = new Recommend();
		user.setRecommendId(recommendId);
		
		service.check(user);
		
		response.sendRedirect("/recommend/main.do");
	}
}
