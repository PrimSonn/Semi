package charsetTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharSetTest {
	public static void main(String[] $) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");){
//			ResultSet rs = conn.createStatement().executeQuery("select * from MOVIES");
//			while(rs.next()) {
//				System.out.println(rs.getString("title"));
//			}
			conn.createStatement().executeUpdate("insert into MOVIES (IDX,TITLE) values(4,\'영화\')");
			ResultSet rs = conn.createStatement().executeQuery("select * from MOVIES");
			while(rs.next()) {
				System.out.println(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
