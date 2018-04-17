package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {
	
	public List selectAll();
	public void insertEmp(Emp emp);
	public Emp selectByEmpNo(int empNo);
	public void deleteByEmpNo(int empNo);
	
}
