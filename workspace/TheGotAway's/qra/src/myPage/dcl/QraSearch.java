package myPage.dcl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPage.dao.QraDao;
import myPage.dto.QraDto;

 


@WebServlet("/dcl/QraSearch")
public class QraSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		String title = req.getParameter("title");
		String q_type = req.getParameter("gk");
	
		
		if(title!=null) {
		QraDao qra = new QraDao();
		
		ArrayList<QraDto> search = new ArrayList<>(); 
		search = qra.qraSearch(title);
	
		
		
		req.setAttribute("search", search);
		
		
	
		} else if(q_type !=null){
			QraDao qra = new QraDao();
			
			ArrayList<QraDto> search = new ArrayList<>(); 
			search = qra.qraType(q_type);
			
			
			req.setAttribute("search", search);
			
			System.out.println(search);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/qra/qraSearch.jsp");
		dispatcher.forward(req, resp);
		
	
		
		
	}
	
}
