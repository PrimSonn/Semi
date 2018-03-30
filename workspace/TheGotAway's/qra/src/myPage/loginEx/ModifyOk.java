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
import javax.servlet.http.HttpSession;


@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;
	
	private String name,id,pw,phone1,phone2,phone3,gender;
    private HttpSession httpSession;
    
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
	 httpSession = request.getSession();
	 
	 name=request.getParameter("name");
	 id=request.getParameter("id");
	 pw=request.getParameter("pw");
	 phone1=request.getParameter("phone1");
	 phone2=request.getParameter("phone2");
	 phone3=request.getParameter("phone3");
	 gender=request.getParameter("gender");
	 
	if(pwConfirm()) {
		 System.out.println("OK");
	 
	 String query = "update member set name = '" + name + "', phone1 = '" + phone1 + "', phone2 = '" + phone2 + "', phone3 ='" + phone3 + "', gender = '" +gender +"'";
	 System.out.println(query);
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		stmt = conn.createStatement();
			
		int i = stmt.executeUpdate(query);
		
		if(i == 1) {
			System.out.println("update 성공");
			httpSession.setAttribute("name", name);
			response.sendRedirect("modifyResult.jsp");
		} else {
			System.out.println("update 실패");
			response.sendRedirect("modify.jsp");
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
	
	private boolean pwConfirm() {
		boolean rs = false;
		
		String sessionPw = (String)httpSession.getAttribute("pw");
		
		if(sessionPw.equals(pw)) {
			rs = true;
		} else {
			rs = false;
		}
		return rs;
	}
}
