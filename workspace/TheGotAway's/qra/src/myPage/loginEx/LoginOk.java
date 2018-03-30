package loginEx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn;
	private Statement stmt;
	private ResultSet res ;
	private String name,id,pw,phone1,phone2,phone3,gender;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
		System.out.println("Post!!");
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		String query = "select * from member where id = '"+ id+ "' and pw = '" + pw +"'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			stmt = conn.createStatement();
			
			res = stmt.executeQuery(query);
			while(res.next()) {
				name = res.getString("name");
				id = res.getString("id");
				pw = res.getString("pw");
				phone1 = res.getString("phone1");
				phone2 = res.getString("phone2");
				phone3 = res.getString("phone3");
				gender = res.getString("gender");
			}
			
			HttpSession httpses = request.getSession();
			httpses.setAttribute("name", name);
			httpses.setAttribute("id", id);
			httpses.setAttribute("pw", pw);
			
			response.sendRedirect("loginResult.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(res != null)		res.close();
					if(stmt != null)	stmt.close();
					if(conn != null)	conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
}
