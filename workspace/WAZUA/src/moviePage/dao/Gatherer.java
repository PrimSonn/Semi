package moviePage.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import moviePage.dto.Pack;
import moviePage.dto.Packer;
import moviePage.func.Func;


public class Gatherer {
	
	private static final String JDBCNAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER, PASS;
	
	private static Connection conn = null;
	private static int COMMENTNUM;

	public void init(String user, String pass, int commentNum) {
		
		USER=user;
		PASS=pass;
		COMMENTNUM = commentNum;

		try {
			Class.forName(JDBCNAME);
			conn = DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Pack getThings(String contextPath, String realPath, String accountIdx, String movieIdx) {
		
		String sql = "select"
						+ " case when M.IDX is not null then 'MOVIE' when MOVIEGUYS_IDX is not null then 'MOVIEGUYS' when COMMENT_IDX is not null then 'ACCOUNT_COMMENT' end as TAG"
						+", M.COUNTRY MOVIE_COUNTRY, M.IDX MOVIE_IDX, M.KORTITLE MOVIE_KORTITLE, M.ENGTITLE MOVIE_ENGTITLE, TO_CHAR(M.RELEASEDATE, 'YYYY-MM-DD') MOVIE_RELEASEDATE, M.PLAYTIME MOVIE_PLAYTIME, M.RATING MOVIE_RATING,SCORE_COUNT MOVIE_SCORECOUNT, M.OUTLINE MOVIE_OUTLINE, M.PRICE MOVIE_PRICE, round(M.TOT_SCORE/M.SCORE_COUNT,2) MOVIE_AVGSCORE, J.GENRE MOVIE_GENRE, M.COMM_COUNT MOVIE_COMMENTCOUNT"
						+", MOVIEGUYS_IDX, MOVIEGUYS_NAME, MOVIEGUYS_ROLE, MOVIEGUYS_CHARACTER"
						+", COMMENT_IDX ACCOUNT_COMMENT_COMMENTIDX, ACCOUNT_IDX , TO_CHAR(COMMENT_REGDATE , 'YYYY.MM.DD') ACCOUNT_COMMENT_REGDATE, COMMENT_CONTENTS ACCOUNT_COMMENT_CONTENTS, COMMENT_ISBLIND ACCOUNT_COMMENT_ISBLIND, ACCOUNT_EMAIL ACCOUNT_COMMENT_EMAIL, ACCOUNT_NAME ACCOUNT_COMMENT_NAME, SCORE ACCOUNT_SCORE" 
					+" from MOVIE M"
					+" inner join (select MM.MOV_IDX MIDX, LISTAGG(MG.GENRE, ',')WITHIN GROUP (order by MOV_IDX)as GENRE from MOVGENRE_MAP MM inner join MOV_GENRE MG on MM.GENRE_IDX = MG.IDX" 
						+" where MM.MOV_IDX = "+movieIdx+" group by MM.MOV_IDX ) J on M.IDX = J.MIDX"
					+" full outer join (select MGMP.MOVGUYS_IDX MOVIEGUYS_IDX, MGYS.NAME MOVIEGUYS_NAME, MGMP.ROLE MOVIEGUYS_ROLE, MGMP.CHARACTER MOVIEGUYS_CHARACTER from MOVGUYS MGYS"
					+" inner join (select MOVGUYS_IDX, ROLE,CHARACTER from MOVGUYS_MAPPING"
					+" where MOV_IDX ="+movieIdx+") MGMP on MGMP.MOVGUYS_IDX = MGYS.IDX) on 1=2"
					+" full outer join (select A.COMMENT_IDX, A.ACCOUNT_IDX, A.COMMENT_REGDATE, A.COMMENT_CONTENTS, A.COMMENT_ISBLIND, B.ACCOUNT_EMAIL, B.ACCOUNT_NAME, SC.SCORE"
						+" from (select CMT.IDX COMMENT_IDX, CMT.ACC_IDX ACCOUNT_IDX, CMT.REG_DATE COMMENT_REGDATE, CMT.CONTENTS COMMENT_CONTENTS, CMT.ISBLIND COMMENT_ISBLIND"
							+" from (select * from COMMENTS where MOVIE_IDX ="+movieIdx+" order by REG_DATE desc) CMT where ROWNUM<="+COMMENTNUM+") A "
							+" inner join (select  ACC_IDX, MOVIE_IDX, SCORE from MVSCORE where MOVIE_IDX = "+movieIdx+") SC on A.ACCOUNT_IDX=SC.ACC_IDX"
							+" inner join (select IDX ACCOUNT_IDX, EMAIL ACCOUNT_EMAIL, NAME ACCOUNT_NAME from ACCOUNT where DEL_FLAG = 'N') B on A.ACCOUNT_IDX = B.ACCOUNT_IDX) on 1=2"
					;
		
		try {
			Statement st = conn.createStatement();
			return new Packer(st.executeQuery(sql), contextPath, realPath);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return (new Pack());//if something's wrong, return empty object
	}
	
	public Pack mvCmtInit(String contextPath, String realPath, String accountIdx, String movieIdx, String commIdx) {
		
		Func func = new Func();
		boolean isEdit = commIdx!=null&&commIdx!=""&func.isInt(commIdx);
		
		String sql = "select"
						+ " case when ACC.IDX is not null then 'ACCOUNT' when IDX is not null then 'MOVIE'";
		if(isEdit) sql+= " when CONTENTS is not null then 'ACCOUNT'";
		sql+= " end as TAG"
						+ ", ACC.IDX ACCOUNT_IDX, NAME ACCOUNT_NAME, SCORE ACCOUNT_SCORE"
						+ ", IDX MOVIE_IDX, KORTITLE MOVIE_KORTITLE, ENGTITLE MOVIE_ENGTITLE";
		if(isEdit) sql+=" , C.CONTENTS ACCOUNT_CONTENTS, C.IDX ACCOUNT_COMMIDX";
		sql+=		 " from ACCOUNT ACC"
					+" inner join (select ACC_IDX, SCORE from MVSCORE where ACC_IDX = "+accountIdx+" and MOVIE_IDX = "+movieIdx+") MVS on ACC.IDX = MVS.ACC_IDX";
		if(isEdit) sql+=" inner join(select CONTENTS, IDX, ACC_IDX from COMMENTS where ACC_IDX = "+accountIdx+" and IDX = "+commIdx+") C on ACC.IDX = C.ACC_IDX";
		sql+=		" full outer join (select IDX, KORTITLE, ENGTITLE from MOVIE where IDX = "+movieIdx+") on 1=2";
		
//		System.out.println(sql);//----------------------------------------------------------testcode
		try {
			Statement st =  conn.createStatement();
			return new Packer(st.executeQuery(sql), contextPath, realPath) ;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return (new Pack());//if something's wrong, return empty object
		
	}
	
	public boolean mvCmtCommit(String id, String mvIdx, boolean nullscore, double doubleScore, String comment, String commIdx) {
		
		Func func = new Func();
		boolean isEdit = false;
		isEdit = commIdx!=null&&commIdx!=""&func.isInt(commIdx);
		String plsql = 
						"declare"
								+" cnt number(1);"
						+" begin";
		if(isEdit) {
			plsql+=			" update COMMENTS set CONTENTS = to_clob('"+comment+"') where ACC_IDX = "+id+" and MOVIE_IDX="+mvIdx+" and IDX="+commIdx+";";
		}else {
			plsql+=			" insert into COMMENTS (ACC_IDX, MOVIE_IDX, CONTENTS) values("+id+","+mvIdx+",to_clob('"+comment+"'));";
		}
		
		if(!nullscore) {
			plsql+=" select count(1)into cnt from MVSCORE where ACC_IDX ="+id+" and MOVIE_IDX ="+mvIdx+";"
					+" if(cnt=0)"
						+" then insert into MVSCORE(ACC_IDX,MOVIE_IDX,SCORE)values("+id+","+mvIdx+","+doubleScore+");"
						+" else update MVSCORE set SCORE="+doubleScore+" where ACC_IDX="+id+" and MOVIE_IDX="+mvIdx+";"
					+" end if;";
		}
		plsql+= " end;";
		
		
		 try {
			CallableStatement cs = conn.prepareCall(plsql);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		};
		
		
		return isEdit;
	}
	
	public Pack moreComments(String contextPath, String realPath, String movieIdx, int minCommNum, int maxCommNum) {
		
		String sql = "select"
							+" case when AC.IDX is not null then 'ACCOUNT' when M.IDX is not null then 'MOVIE' end as TAG"
							+" , AC.IDX ACCOUNT_IDX, AC.NAME ACCOUNT_NAME, C.IDX ACCOUNT_COMMIDX, C.REG_DATE ACCOUNT_REGDATE, C.CONTENTS ACCOUNT_CONTENTS, C.ISBLIND ACCOUNT_ISBLIND, NUM ACCOUNT_COMMNUM, S.ACC_IDX ACCOUNT_SCORE"
							+" , M.IDX MOVIE_IDX, M.ENGTITLE MOVIE_ENGTITLE, M.KORTITLE MOVIE_KORTITLE, M.COMM_COUNT MOVIE_COMMCOUNT"
						+" from ACCOUNT AC"
						+" inner join"
						+" (select IDX, ACC_IDX, REG_DATE, CONTENTS, ISBLIND, rownum NUM from "
							+ "(select IDX, ACC_IDX, REG_DATE, CONTENTS, ISBLIND from COMMENTS where MOVIE_IDX="+movieIdx+" order by REG_DATE desc)) C"
						+" on C.ACC_IDX=AC.IDX and NUM between "+minCommNum+" and "+maxCommNum
						+" inner join (select SCORE, ACC_IDX from MVSCORE where MOVIE_IDX ="+movieIdx+")S on S.ACC_IDX = AC.IDX "
						+" full outer join (select IDX, ENGTITLE, KORTITLE, COMM_COUNT from MOVIE where IDX = "+movieIdx+") M on 1=2";
		
		try {
			Statement st = conn.createStatement();
			return new Packer(st.executeQuery(sql), contextPath, realPath) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (new Pack());//if something's wrong, return empty object
		
	}
	
	public int delComment(String commIdx, String mvIdx, String accIdx) {
		
		String sql = "delete from COMMENTS where IDX="+commIdx+" and MOVIE_IDX="+mvIdx+" and ACC_IDX="+accIdx;
		try {
			Statement st = conn.createStatement();
			return st.executeUpdate(sql);
		}catch (SQLException Noooooo) {
			Noooooo.printStackTrace();
			return -1;
		}
	}
}
