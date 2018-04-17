package dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
	
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private Date hireDate;
	private int sal;
	private int comm;
	private int deptNo;
	
	@Override
	public String toString() {
		DateFormat formatter = new SimpleDateFormat("YYYY/MM/dd");
		String stDate = formatter.format(hireDate);
		return "Emp [empNo: "+empNo+" eName: "+eName+" job: "+job+" mgr: "+mgr+" hireDate: "+stDate+" sal: "+sal+" comm: "+comm+" deptNo: "+deptNo+"]";
	}
	
	public int getComm() {
		return comm;
	}public int getDeptNo() {
		return deptNo;
	}public int getEmpNo() {
		return empNo;
	}public String geteName() {
		return eName;
	}public String getHireDate() {
		DateFormat formatter = new SimpleDateFormat("YYYY/MM/dd");
		return formatter.format(hireDate);
	}public String getJob() {
		return job;
	}public int getMgr() {
		return mgr;
	}public int getSal() {
		return sal;
	}public void setComm(int comm) {
		this.comm = comm;
	}public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}public void seteName(String eName) {
		this.eName = eName;
	}public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}public void setJob(String job) {
		this.job = job;
	}public void setMgr(int mgr) {
		this.mgr = mgr;
	}public void setSal(int sal) {
		this.sal = sal;
	}
}
