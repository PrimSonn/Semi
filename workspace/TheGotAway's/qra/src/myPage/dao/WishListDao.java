package myPage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import myPage.dto.WishListDto;

 

public class WishListDao {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";

	public WishListDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	public ArrayList<WishListDto> wish(){
		ArrayList<WishListDto> dtos = new ArrayList<>();
	
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = "select * from wish_list";
		
		
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		while(res.next()) {
			int idx = res.getInt("idx");
			int mv_idx = res.getInt("mv_idx");
			String flag = res.getString("flag");
			
			WishListDto dto = new WishListDto(idx, mv_idx, flag);
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
