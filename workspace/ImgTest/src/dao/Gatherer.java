package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Pack;
import dto.Packer;

public class Gatherer {
	
	private static final String JDBCNAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "scott", PASS = "tiger";
	
	private Connection conn = null;
	private PreparedStatement pst = null;
		
	public Gatherer() {
		
			try {
				Class.forName(JDBCNAME);
				conn = DriverManager.getConnection(URL,USER,PASS);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	public Pack getThings(String contextPath, String realPath, String AccountIdx, String MovieIdx) {
		
		
		String sql = "select C.IDX COMMENT_IDX, C.TITLE COMMENT_TITLE, MOVIE_IDX MOVIE_IDX, MOVIE_TITLE MOVIE_SELECTED_TITLE, ACCOUNT_IDX, ACCOUNT_ID ACCOUNT_SELECTED_ID," + 
						" case" + 
							" when T.ACCOUNT_IDX =1 then 'ACCOUNT_SELECTED'" + 
							" when T.ACCOUNT_IDX is not null then 'ACCOUNT'" + 
							" when T.MOVIE_IDX =1 then 'MOVIE_SELECTED'" + 
							" when T.MOVIE_IDX is not null then 'MOVIE'" + 
							" when C.IDX is not null then 'COMMENT'" + 
						" end as TAG" + 
					" from MOVIE_COMMENTS C full outer join (" + 
						" select M.IDX MOVIE_IDX , A.IDX ACCOUNT_IDX, M.TITLE MOVIE_TITLE , A.ID ACCOUNT_ID from MOVIES M full outer join ACCOUNTS A on 1=2) T" + 
					" on 1=2";
		
		try {
			pst = conn.prepareStatement(sql);
//			pst.setString(1, AccountIdx);
//			pst.setString(2, MovieIdx);
			return new Packer(pst.executeQuery(), contextPath, realPath) ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
