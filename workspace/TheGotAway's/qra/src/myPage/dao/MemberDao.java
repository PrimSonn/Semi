package myPage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import myPage.dto.MemberDto;

 

public class MemberDao {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public MemberDao() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}	
		
	}
	
	public ArrayList<MemberDto> memberSelect(){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
		con = DriverManager.getConnection(url,uid,upw);
		stmt = con.createStatement();
		res = stmt.executeQuery("select * from member");
		
		while(res.next()) {
			String name = res.getString("name");
			String add1 = res.getString("add1");
			String add2 = res.getString("add2");
			String pw = res.getString("pw");
			String br= res.getString("br");
			
			MemberDto dto = new MemberDto(name, add1, add2, pw, br);
			dtos.add(dto);
		}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res !=null)	res.close();
				if(stmt!=null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
}
