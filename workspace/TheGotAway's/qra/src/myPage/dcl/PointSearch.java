package myPage.dcl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPage.dao.PointDao;
import myPage.dto.Point_bd_Dto;

 
@WebServlet("/dcl/PointSearch")
public class PointSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String title = req.getParameter("title");
		PointDao point = new PointDao();
		ArrayList<Point_bd_Dto> search = new ArrayList<>();
		search = point.pointSearch(title);
		
		req.setAttribute("search", search);
		
		RequestDispatcher disp = req.getRequestDispatcher("/myPoint/myPointSearch.jsp");
		disp.forward(req, resp);
	}

}