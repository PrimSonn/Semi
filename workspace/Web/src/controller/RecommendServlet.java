package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Recommend;
import service.RecommendService;
import service.RecommendServiceimpl;

/**
 * Servlet implementation class RecommendServlet
 */
@WebServlet("/recommend/main.do")
public class RecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecommendService recommendService = null;
		recommendService = new RecommendServiceimpl();
		int total = recommendService.getTotal();
		
		request.setAttribute("total", total);
		
		
		List<Recommend> ids = recommendService.getIDs();
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		String names="";
		for(Recommend rec:ids) {
			names.concat(rec.getRecommendId()+", ");
		}
		System.out.println("test code, names concat: " + names);
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		request.setAttribute("IDs", ids);
		
		for(Recommend rec:ids) {
			System.out.println(rec.getRecommendId());
		}
		
						
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/view/recommend/main.jsp");
		rd.forward(request, response);
	}

}
