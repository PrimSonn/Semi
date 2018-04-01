package driver.dummyMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DummyMaker {
	
	private static final String JDBCNAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "WAZUA", PASS = "WAZUA";
	private static Statement st = null;
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	
	public static void main(String[] a) {
		try {
			Class.forName(JDBCNAME);
			conn = DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "insert all";
		ArrayList<String> sqlList = new ArrayList<String>();
		
		for(int i=1;i<=5;i++) {
			String temp="";
			for(int j =0;j<100;j++) {
				temp+=i+"줄거리줄거리";
			}
			sql += " into MOVIE (KORTITLE, ENGTITLE, COUNTRY, RELEASEDATE, RATING, PLAYTIME, VIEWCOUNT, OUTLINE, TICKETSOLD, PRICE)"
					+ " values (\'"+i+"번 한국영화이름\', \'"+i+"th EngMovieTitle\', \'"+i+"번 국가\', TO_DATE(\'2018/0"+i+"/0"+i+"\', \'yyyy/mm/dd\'),\'"+i+"세 이용가\',\'"+i+"시간\',"+i*11+", to_clob(\'"+temp+"\'), "+i*100+" , "+i*1000+")";
		}
		sql+=" select 1 from DUAL;";
		
//		String b = "insert all" +
//				"	into MOVIES (IDX, TITLE) values (1,'Movie1')" +
//				"	into MOVIES (IDX, TITLE) values (2, '영화2')" +
//				"	into ACCOUNTS (IDX, ID) values (1, 'Id1')" +
//				"	into ACCOUNTS (IDX, ID) values (2, '아이디2')" +
//				"	into MOVIE_COMMENTS (IDX, TITLE) values (1, 'Comment1')" +
//				"	into MOVIE_COMMENTS (IDX, TITLE) values (2, '덧글2')" +
//				"	into MOVIE_COMMENTS (IDX, TITLE) values (3, 'Comment1')" +
//				" select 1 from DUAL;";
		
		sqlList.add(sql);
		sql="";
		for(int i=1;i<=5;i++) {
			String temp ="";
			for(int j=0;j<100;j++) {
				temp+=i+"댓글내용";
			}
			for(int k=1;k<=5;k++) {
				sql+="insert into COMMENTS(ACC_IDX,MOVIE_IDX,CONTENTS) values("+k+","+i+",to_clob(\'"+i+" 영화댓글 "+temp+"\'));\r\n";
			}
		}
		sql="insert all";
		for(int i=1;i<=5;i++) {
			for(int k=1;k<=5;k++) {
				sql+=" into MVSCORE(ACC_IDX, MOVIE_IDX, SCORE)"+"values("+k+","+i+","+((double)i+((double)k)/10)+")";
			}
		}
		sql += " select 1 from DUAL;";
		System.out.println(sql);
//		try {
//			conn.createStatement().executeUpdate(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
	
}
