package myPage.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPage.dto.QraDto;

 




@WebServlet("/dao/QraSearch")
public class QraSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action1(req, resp);
		
	}
	
	
	protected void action1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		ArrayList<QraDto> dtos = new ArrayList<QraDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			String title = req.getParameter("title");
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery("select * from qra where q_title = '"+title+"'");
			
			if(res.next()) {
				String q_type = res.getString("q_type");
				int idx = res.getInt("idx");
				int mem_idx = res.getInt("mem_idx");
				String q_title = res.getString("q_title");
				String q_ctnt = res.getString("q_ctnt");
				String a_ctnt = res.getString("a_ctnt");
				Date q_date = res.getDate("q_date");
				Date a_date = res.getDate("a_date");
				String status=res.getString("status");	
				
				QraDto dto = new QraDto(q_type,idx, mem_idx,q_title, q_ctnt, a_ctnt, q_date, a_date,status);
				dtos.add(dto);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res!=null)	res.close();
				if(stmt!=null)	stmt.close();
				if(con!=null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/qra/qraSearch.jsp");
		dispatcher.forward(req, resp);
		
	}

	protected void action2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		ArrayList<QraDto> dtos = new ArrayList<QraDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			String gk = req.getParameter("gk");
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery("select * from qra where q_title = '"+gk+"'");
			
			if(res.next()) {
				String q_type = res.getString("q_type");
				int idx = res.getInt("idx");
				int mem_idx = res.getInt("mem_idx");
				String q_title = res.getString("q_title");
				String q_ctnt = res.getString("q_ctnt");
				String a_ctnt = res.getString("a_ctnt");
				Date q_date = res.getDate("q_date");
				Date a_date = res.getDate("a_date");
				String status=res.getString("status");	
				
				QraDto dto = new QraDto(q_type,idx, mem_idx,q_title, q_ctnt, a_ctnt, q_date, a_date,status);
				dtos.add(dto);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res!=null)	res.close();
				if(stmt!=null)	stmt.close();
				if(con!=null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/qra/qraSearch.jsp");
		dispatcher.forward(req, resp);
		
	}

	
}
