package signUp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import signUp.dto.Account;

public class SignUpDao {
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String tbUser = "scott";
	private final String tbPass = "scott";
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public SignUpDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,tbUser,tbPass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean signUp(Account account) {
		
		try {
			pst = conn.prepareStatement("insert into ACCOUNT_TB (id,pw) values (?,?)");
			pst.setString(1, account.getId());
			pst.setString(2, account.getPw());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public boolean signIn(Account account) {
		
		try {
			pst=conn.prepareStatement("select PW from ACCOUNT_TB where ID=?");
			pst.setString(1, account.getId());
			
			rs = pst.executeQuery();
			rs.next();
			String pw = rs.getString("PW");
			if(""==pw) {
				return false;
			} else if(pw!=account.getPw()) {
				return false;
			} else {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
