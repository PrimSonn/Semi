package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Gatherer {
	
	private static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER= "scott";
	private static final String PASS = "tiger";
	
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	public Gatherer() {
		
	}
	
}
