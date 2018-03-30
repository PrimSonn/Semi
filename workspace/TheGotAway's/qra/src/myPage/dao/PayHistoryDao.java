package myPage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import myPage.dto.PayHistoryDto;

 

public class PayHistoryDao {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public PayHistoryDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PayHistoryDto> pay(){
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		String sql = "select * from payment where status = 'y'";
		
		ArrayList<PayHistoryDto> dtos = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		
			while(res.next()) {
				
				int idx = res.getInt("idx");
				int mem_idx = res.getInt("mem_idx");
				int mv_idx = res.getInt("mv_idx");
				int fs_idx = res.getInt("fs_idx");
				Date p_date = res.getDate("p_date");
				int pay = res.getInt("pay");
				String method = res.getString("method");
				String status = res.getString("status");
				PayHistoryDto dto = new PayHistoryDto(idx, mem_idx, mv_idx, fs_idx, p_date, pay, method, status);
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

	public ArrayList<PayHistoryDto> payreset(){
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		String sql = "select * from payment where status = 'n'";
		
		ArrayList<PayHistoryDto> dtos = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		
			while(res.next()) {
				
				int idx = res.getInt("idx");
				int mem_idx = res.getInt("mem_idx");
				int mv_idx = res.getInt("mv_idx");
				int fs_idx = res.getInt("fs_idx");
				Date p_date = res.getDate("p_date");
				int pay = res.getInt("pay");
				String method = res.getString("method");
				String status = res.getString("status");
				PayHistoryDto dto = new PayHistoryDto(idx, mem_idx, mv_idx, fs_idx, p_date, pay, method, status);
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
	public ArrayList<PayHistoryDto> paySearch(String title){
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		String sql = "select * from payment where method like '%"+title+"%'";
		
		ArrayList<PayHistoryDto> dtos = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
		
			while(res.next()) {
				
				int idx = res.getInt("idx");
				int mem_idx = res.getInt("mem_idx");
				int mv_idx = res.getInt("mv_idx");
				int fs_idx = res.getInt("fs_idx");
				Date p_date = res.getDate("p_date");
				int pay = res.getInt("pay");
				String method = res.getString("method");
				String status = res.getString("status");
				PayHistoryDto dto = new PayHistoryDto(idx, mem_idx, mv_idx, fs_idx, p_date, pay, method, status);
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
