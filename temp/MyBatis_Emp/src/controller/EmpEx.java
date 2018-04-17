package controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	public static void main(String[] aaaa) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);
		
		List<Emp> emplist = empDao.selectAll();
		System.out.println("selectAll:");
		for(Emp emp: emplist) {
			System.out.println(emp);
		}
		
		Emp emp = (Emp)emplist.get(0);
		emp.setEmpNo(1234);
		System.out.println("after setEmpNo: "+emp);
		empDao.insertEmp(emp);
		
		emp = empDao.selectByEmpNo(1234);
		if(emp ==null) {
			System.out.println("no emp with EmpNo:1234");
			sqlSession.rollback();
		}else {
			System.out.println("success");
			sqlSession.commit();
			
			System.out.println("-------------------------------------");
			emplist = empDao.selectAll();
			System.out.println("selectAll:");
			for(Emp e: emplist) {
				System.out.println(e);
			}
			
			empDao.deleteByEmpNo(1234);
			if(empDao.selectByEmpNo(1234)==null) {
				System.out.println("emp with EmpNo:1234 deleted");
				sqlSession.commit();
			}else {
				System.out.println("not deleted properly");
				sqlSession.rollback();
			}
		}
		
		System.out.println("-------------------------------------");
		emplist = empDao.selectAll();
		System.out.println("selectAll:");
		for(Emp e: emplist) {
			System.out.println(e);
		}
		
	}
}
