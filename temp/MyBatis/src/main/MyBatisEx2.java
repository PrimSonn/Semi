package main;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.DeptDao;
import dto.Dept;
import myBatis.MyBatisConnFactory;

public class MyBatisEx2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Dept insertDept = new Dept();
		
//		System.out.println("insert DeptNo: ");
//		insertDept.setDeptNo(sc.nextInt());
//		sc.skip("\r\n");
//		System.out.println("insert DName: ");
//		insertDept.setdName(sc.nextLine());
//		System.out.println("insert Loc: ");
//		insertDept.setLoc(sc.nextLine());
		
		insertDept.setDeptNo(12);
		insertDept.setdName("AAA");
		insertDept.setLoc("BB");;
		
//		System.out.println(insertDept);
		
		MyBatisConnFactory.getSqlSessionFactory().openSession().getMapper(DeptDao.class)
			.insert(insertDept.getDeptNo(), insertDept.getdName(), insertDept.getLoc());
		
//		SqlSession sqlsession = MyBatisConnFactory.getSqlSessionFactory().openSession(true);
		
		/*
		SqlSession sqlsession = MyBatisConnFactory.getSqlSessionFactory().openSession();
		
		DeptDao deptdao = sqlsession.getMapper(DeptDao.class);
		
		deptdao.insert(insertDept);
		
		Dept result = deptdao.selectByDeptNo(insertDept.getDeptNo());
		
		if( result ==null) {
			sqlsession.rollback();
			System.out.println("failed");
		}
		else {
			sqlsession.commit();
			System.out.println("success");
		}
		*/
		
	}

}
