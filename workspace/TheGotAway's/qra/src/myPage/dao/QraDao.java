package myPage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

import myPage.dto.QraDto;

 

public class QraDao {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public QraDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<QraDto> qra(){
		ArrayList<QraDto> dtos = new ArrayList<QraDto>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery("select * from qra order by idx asc");

			while(res.next()) {
				
				String q_type = res.getString("q_type");
				int idx = res.getInt("idx");
				int mem_idx = res.getInt("mem_idx");
				String q_title = res.getString("q_title");
				String q_ctnt = res.getString("q_ctnt");
				String a_ctnt = res.getString("a_ctnt");
				Date q_date = res.getDate("a_date");
				Date a_date = res.getDate("a_date");
 				String status = res.getString("status");
 				
 				QraDto dto = new QraDto(q_type,idx, mem_idx,q_title, q_ctnt, a_ctnt, q_date, a_date,status);
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
	public ArrayList<QraDto> qraSearch(String title){
		
	ArrayList<QraDto> dtos = new ArrayList<QraDto>();
	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	
	try {
		con = DriverManager.getConnection(url,uid,upw);
		stmt = con.createStatement();
		res = stmt.executeQuery("select * from qra where q_title like '%"+title+"%' order by q_date");
		
		while(res.next()) {
			
			String q_type = res.getString("q_type");
			int idx = res.getInt("idx");
			int mem_idx = res.getInt("mem_idx");
			String q_title = res.getString("q_title");
			String q_ctnt = res.getString("q_ctnt");
			String a_ctnt = res.getString("a_ctnt");
			Date q_date = res.getDate("q_date");
			Date a_date = res.getDate("a_date");
			String status=res.getString("status");	

			QraDto dto = new QraDto(q_type,idx, mem_idx,q_title, q_ctnt, a_ctnt, q_date, a_date,status);
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
	public ArrayList<QraDto> qraType(String type){
		
		ArrayList<QraDto> dtos = new ArrayList<QraDto>();
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			res = stmt.executeQuery("select * from qra where q_type = '"+type+"'");
			
			while(res.next()) {
				
				String q_type = res.getString("q_type");
				int idx = res.getInt("idx");
				int mem_idx = res.getInt("mem_idx");
				String q_title = res.getString("q_title");
				String q_ctnt = res.getString("q_ctnt");
				String a_ctnt = res.getString("a_ctnt");
				Date q_date = res.getDate("q_date");
				Date a_date = res.getDate("a_date");
				String status=res.getString("status");	

				QraDto dto = new QraDto(q_type,idx, mem_idx,q_title, q_ctnt, a_ctnt, q_date, a_date,status);
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


