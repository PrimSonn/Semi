package myPage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import myPage.dto.commentDto;



public class commentDao {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public commentDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<commentDto> comm(){
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		String sql = "select * from m_comment order by reg_date desc";
		
		ArrayList<commentDto> dtos = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		
			while(res.next()) {
				
				int idx = res.getInt("idx");
				int mem_idx = res.getInt("mem_idx");
				String c_title = res.getString("c_title");
				Date reg_date = res.getDate("reg_date");
				String content = res.getString("content");
				String blind = res.getString("blind");
				
				commentDto dto = new commentDto(idx, mem_idx, c_title, reg_date, content, blind);
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
		
		return dtos;
		
	}
}
