package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Recommend;

public class RecommendDaoImpl implements RecommendDao{
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "scott";
	private final String PASSWORD = "tiger";
	
	private PreparedStatement pst = null;
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	
	public RecommendDaoImpl() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getTotal() {
		String sql = "select count(*) from RECOMMEND_TB";
		
		try {
			
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			
			rs.next();
			return rs.getInt(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public boolean check(Recommend r) {
		String sql = "select count(*) from RECOMMEND_TB"+" where RECOMMEND_ID = ?";
		
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,r.getRecommendId());

			rs= pst.executeQuery();
			rs.next();
			int res = rs.getInt(1);
			System.out.println("count(*): "+res);
			
			if(res>0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void insert(Recommend r) {
		String sql = "insert into RECOMMEND_TB values(?)";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, r.getRecommendId());
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Recommend r) {
		
		String sql = "delete RECOMMEND_TB where RECOMMEND_ID = (?)";
		
		try {
			
			pst=conn.prepareStatement(sql);
			pst.setString(1,r.getRecommendId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List getIds() {
		String sql = "select RECOMMEND_ID from RECOMMEND_TB order by RECOMMEND_ID";
		List<Recommend> ids = new ArrayList();
		try {
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next()) {
				Recommend recommend = new Recommend();
				recommend.setRecommendId(rs.getString(1));
				ids.add(recommend);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}
}
