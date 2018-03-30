package loginEx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private Connection conn;
	private Statement stmt;
	
	private String name,id,pw,phone1,phone2,phone3,gender;
    
	public JoinOk() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do Get");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do Post");
		actionDo(request,response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("UTF-8");
	 
	 name=request.getParameter("name");
	 id=request.getParameter("id");
	 pw=request.getParameter("pw");
	 phone1=request.getParameter("phone1");
	 phone2=request.getParameter("phone2");
	 phone3=request.getParameter("phone3");
	 gender=request.getParameter("gender");
	 
	 String query = "insert into member values('" + name + "','" + id + "','" + pw + "','" + phone1 + "','" + phone2 + "','" + phone3 + "','" +gender +"')";
	 
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		stmt = conn.createStatement();
		
		int i = stmt.executeUpdate(query);
		
		if(i == 1) {
			System.out.println("inser 성공");
			response.sendRedirect("joinResult.jsp");
		} else {
			System.out.println("inser 실패");
			response.sendRedirect("join.html");
		}
	 } catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
			try {
				if(stmt != null)	stmt.close();
				if(conn != null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 
	}

}
