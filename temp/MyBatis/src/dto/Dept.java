package dto;

public class Dept {
	
	private int deptNo;
	private String dName;
	private String loc;
	
	@Override
	public String toString() {
		return "Dept[deptNo: "+deptNo+"  dName: "+dName+"  loc: "+loc+"]";
	}
	
	public int getDeptNo() {
		return deptNo;
	}public String getdName() {
		return dName;
	}public String getLoc() {
		return loc;
	}public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}public void setdName(String dName) {
		this.dName = dName;
	}public void setLoc(String loc) {
		this.loc = loc;
	}
}
