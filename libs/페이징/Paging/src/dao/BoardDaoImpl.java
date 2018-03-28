package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import util.Paging;

public class BoardDaoImpl implements BoardDao {

	// DB 정보
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "scott";
	private String password = "tiger";

	private Connection conn = null;

	public BoardDaoImpl() {
		try {
			// Oracle jdbc Driver 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Connection 객체 생성
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// 총 게시물 수 반환
	@Override
	public int getTotal() {
		Statement st = null;
		ResultSet rs = null;

		String sql="SELECT COUNT(*) FROM board";

		int total = 0;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			rs.next();
			
			total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(rs!=null)	rs.close();
				if(st!=null)	st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}
	
	// 페이징 처리하여 게시물 리스트 가져오기
	@Override
	public List getList(Paging paging) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<Board> list = new ArrayList<>();
		
		String sql =
				"SELECT * FROM ("
				+ " SELECT rownum rnum, b.* FROM ("
				+ " 	SELECT boardno, title, writer, hit, recommend, writtendate"
				+ " 	FROM board"
				+ " 	ORDER BY boardno DESC"
				+ " ) b"
				+ " ORDER BY rnum"
				+ ") WHERE rnum BETWEEN ? AND ?";
					
		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, paging.getStartNo());
			pst.setInt(2, paging.getEndNo());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setHit(rs.getInt("hit"));
				board.setRecommend(rs.getInt("recommend"));
				board.setWrittenDate(rs.getDate("writtendate"));
				
				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(pst!=null)	pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;			
	}
	

}
