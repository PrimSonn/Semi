package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class Gatherer {
	
	private static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER= "scott";
	private static final String PASS = "tiger";
	
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	
	public Gatherer() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}//gatherer ends
	
	public boolean getThings(HttpServletRequest request) {
		
		return false;
	}
	
}
