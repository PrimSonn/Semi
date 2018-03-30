package myPage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import myPage.dto.RatingDto;
 

public class RatingDao {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";

	public RatingDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<RatingDto> rating(){
		ArrayList<RatingDto> dtos = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = "select * from rating";
		
		System.out.println(sql);
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		while(res.next()) {
			int idx = res.getInt("idx");
			String rate = res.getString("rate");
			
			RatingDto dto = new RatingDto(idx, rate);
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
