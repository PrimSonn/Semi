package web.dto;

public class UserVo {
	private String id;
	private String pw;
	
	@Override
	public String toString() {
		return "User [ID: "+id+", PW: "+pw+"]";
	}
	
	public String getId() {
		return id;
	}public String getPw() {
		return pw;
	}public void setId(String id) {
		this.id = id;
	}public void setPw(String pw) {
		this.pw = pw;
	}
}
