package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	private MyBatisConnectionFactory() {}
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String res = "mybatis/mybatis-config.xml";
		try {
			
			Reader reader = Resources.getResourceAsReader(res);
			if(sqlSessionFactory==null) sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
