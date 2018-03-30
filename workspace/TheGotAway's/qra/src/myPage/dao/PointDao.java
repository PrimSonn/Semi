package myPage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myPage.dto.PointDto;
import myPage.dto.Point_bd_Dto;
 

public class PointDao {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";

	
	public PointDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<PointDto> retpdao(){
		ArrayList<PointDto> dtos = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet res = null;
		String sql = "select * from ret_point";
		
			 
			try {
				con = DriverManager.getConnection(url,uid,upw);
				ptmt = con.prepareStatement(sql);
				res = ptmt.executeQuery();

				while(res.next()) {
				
				int idx = res.getInt("idx");
				int point = res.getInt("point"); 
				Date get_date = res.getDate("get_date");
				Date exp_date = res.getDate("exp_date");
				
				PointDto dto = new PointDto(idx, point, get_date, exp_date);
				dtos.add(dto);
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if(res != null)	res.close();
			if(ptmt!=null)	ptmt.close();
			if(con!=null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;
		
	}

	public ArrayList<Point_bd_Dto> pbddao(){
		ArrayList<Point_bd_Dto> dtos = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet res = null;
		String sql = "select * from point_bd";
		
			 
			try {
				con = DriverManager.getConnection(url,uid,upw);
				ptmt = con.prepareStatement(sql);
				res = ptmt.executeQuery();

				while(res.next()) {
				
				int idx = res.getInt("idx");
				Date cng_date = res.getDate("cng_date");
				String cng_cus= res.getString("cng_cus");
				int rec_pnt = res.getInt("rec_pnt");
				int use_pnt = res.getInt("use_pnt");
				String status = res.getString("status");
				
				Point_bd_Dto dto = new Point_bd_Dto(idx, cng_date, cng_cus,rec_pnt, use_pnt, status);
				dtos.add(dto);
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if(res != null)	res.close();
			if(ptmt!=null)	ptmt.close();
			if(con!=null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;
		
	}
	
	public ArrayList<Point_bd_Dto> pointSearch(String title){
		ArrayList<Point_bd_Dto> dtos = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet res = null;
		String sql = "select * from point_bd where cng_cus like '%"+title+"%' order by  cng_date";
		
			 
			try {
				con = DriverManager.getConnection(url,uid,upw);
				ptmt = con.prepareStatement(sql);
				res = ptmt.executeQuery();

				while(res.next()) {
				
				int idx = res.getInt("idx");
				Date cng_date = res.getDate("cng_date");
				String cng_cus= res.getString("cng_cus");
				int rec_pnt = res.getInt("rec_pnt");
				int use_pnt = res.getInt("use_pnt");
				String status = res.getString("status");
				
				Point_bd_Dto dto = new Point_bd_Dto(idx, cng_date, cng_cus,rec_pnt, use_pnt, status);
				dtos.add(dto);
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if(res != null)	res.close();
			if(ptmt!=null)	ptmt.close();
			if(con!=null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;
		
	}
}

