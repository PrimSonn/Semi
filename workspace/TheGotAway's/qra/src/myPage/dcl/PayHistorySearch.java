package myPage.dcl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPage.dao.PayHistoryDao;
import myPage.dto.PayHistoryDto;

 

@WebServlet("/dcl/PayHistorySearch")
public class PayHistorySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html; charset =utf-8");
		
		String title = req.getParameter("title");
		PayHistoryDao pay = new PayHistoryDao();
		ArrayList<PayHistoryDto> search = new ArrayList<>();
		search = pay.paySearch(title);
		
		req.setAttribute("search", search);
		
		RequestDispatcher disp = req.getRequestDispatcher("/payHistory/payHistorySearch.jsp");
		disp.forward(req, resp);
		
		
	}


}
