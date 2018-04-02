package countUp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CntDao {
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "scott";
	private final String PASSWORD = "tiger";
	
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	
	public CntDao() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public CntVo getCount() {
		
		String sql = "select CNT from CNT";
		
		try {
			st = conn.createStatement();
			
			rs=st.executeQuery(sql);
			rs.next();
			CntVo vo = new CntVo();
			vo.setCnt(rs.getInt("cnt"));
			
			return vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("you shouldn't be here");
		return null;
	}
	
	void setCount(CntVo vo) {
		
		String sql = "update CNT set CNT = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, vo.getCnt());
			
			if(pst.executeUpdate()<=0) {
//				return false;
			} else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
