package moviePage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import moviePage.dto.Pack;
import moviePage.dto.Packer;


public class Gatherer {
	
	private static final String JDBCNAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER, PASS;
	
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static final int COMMENTNUM = 3;
	
	public void init(String user, String pass) {
		USER=user;
		PASS=pass;
		try {
			Class.forName(JDBCNAME);
			conn = DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Pack getThings(String contextPath, String realPath, String AccountIdx, String movieIdx) {
		
		
		String sql = "select"
						+ " case when M.IDX is not null then 'MOVIE' when MOVIEGUYS_IDX is not null then 'MOVIEGUYS' when COMMENT_IDX is not null then 'ACCOUNT_COMMENT' end as TAG"
						+", M.COUNTRY MOVIE_COUNTRY, M.IDX MOVIE_IDX, M.KORTITLE MOVIE_KORTITLE, M.ENGTITLE MOVIE_ENGTITLE, TO_CHAR(M.RELEASEDATE, 'YYYY-MM-DD') MOVIE_RELEASEDATE, M.PLAYTIME MOVIE_PLAYTIME, M.RATING MOVIE_RATING,SCORE_COUNT MOVIE_SCORECOUNT, M.OUTLINE MOVIE_OUTLINE, M.PRICE MOVIE_PRICE, M.TOT_SCORE/M.SCORE_COUNT MOVIE_AVGSCORE, J.GENRE MOVIE_GENRE,C.C_COUNT MOVIE_COMMENTCOUNT"
						+", MOVIEGUYS_IDX, MOVIEGUYS_NAME, MOVIEGUYS_ROLE, MOVIEGUYS_CHARACTER"
						+", COMMENT_IDX ACCOUNT_COMMENT_COMMENTIDX, ACCOUNT_IDX , TO_CHAR(COMMENT_REGDATE , 'YYYY.MM.DD') ACCOUNT_COMMENT_REGDATE, COMMENT_CONTENTS ACCOUNT_COMMENT_CONTENTS, COMMENT_ISBLIND ACCOUNT_COMMENT_ISBLIND, ACCOUNT_EMAIL ACCOUNT_COMMENT_EMAIL, ACCOUNT_NAME ACCOUNT_COMMENT_NAME" 
					+" from MOVIE M"
					+" inner join (select MOVIE_IDX, count(MOVIE_IDX) as C_COUNT from COMMENTS group by MOVIE_IDX"
					+" having MOVIE_IDX ="+movieIdx+")"
					+" C on M.IDX = C.MOVIE_IDX"
					+" inner join (select MM.MOV_IDX MIDX, LISTAGG(MG.GENRE, ',')WITHIN GROUP (order by MOV_IDX)as GENRE from MOVGENRE_MAP MM inner join MOV_GENRE MG on MM.GENRE_IDX = MG.IDX" 
						+" where MM.MOV_IDX = "+movieIdx+" group by MM.MOV_IDX ) J on M.IDX = J.MIDX"
					+" full outer join (select MGMP.MOVGUYS_IDX MOVIEGUYS_IDX, MGYS.NAME MOVIEGUYS_NAME, MGMP.ROLE MOVIEGUYS_ROLE, MGMP.CHARACTER MOVIEGUYS_CHARACTER from MOVGUYS MGYS"
					+" inner join (select MOVGUYS_IDX, ROLE,CHARACTER from MOVGUYS_MAPPING"
					+" where MOV_IDX ="+movieIdx+") MGMP on MGMP.MOVGUYS_IDX = MGYS.IDX) on 1=2"
					+" full outer join (select A.COMMENT_IDX, A.ACCOUNT_IDX, A.COMMENT_REGDATE, A.COMMENT_CONTENTS, A.COMMENT_ISBLIND, B.ACCOUNT_EMAIL, B.ACCOUNT_NAME"
						+" from (select CMT.IDX COMMENT_IDX, CMT.ACC_IDX ACCOUNT_IDX, CMT.REG_DATE COMMENT_REGDATE, CMT.CONTENTS COMMENT_CONTENTS, CMT.ISBLIND COMMENT_ISBLIND"
							+" from (select * from COMMENTS where MOVIE_IDX ="+movieIdx+" order by REG_DATE) CMT where ROWNUM<="+COMMENTNUM+") A inner join (select IDX ACCOUNT_IDX, EMAIL ACCOUNT_EMAIL, NAME ACCOUNT_NAME from ACCOUNT where DEL_FLAG = 'N') B on A.ACCOUNT_IDX = B.ACCOUNT_IDX) on 1=2"
					;
		
		try {
			pst = conn.prepareStatement(sql);
			return new Packer(pst.executeQuery(), contextPath, realPath) ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
