package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dto.Dept;

public interface DeptDao {
	public Dept selectByDeptNo(int deptNo);
	public List selectAll();
	public void insert(@Param("deptNo") int deptNo, @Param("dName") String dName, @Param("loc") String loc);
//	public void insert(Dept insertDept);
}
