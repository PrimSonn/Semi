package main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.DeptDao;
import dto.Dept;
import myBatis.MyBatisConnFactory;

public class MyBatisEx {

	public static void main(String[] args) {
		
		SqlSession sqlSession = MyBatisConnFactory.getSqlSessionFactory().openSession();
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		
		Dept resultDept = deptDao.selectByDeptNo(10);
		
		System.out.println(resultDept);
		
		List list = deptDao.selectAll();
		System.out.println(list);

	}

}
