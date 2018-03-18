package signUp.dto;

public class Account {
	private String id;
	private String pw;
	private String pw2;
	private int idx;
	public String getId() {
		return id;
	}public int getIdx() {
		return idx;
	}public String getPw() {
		return pw;
	}public String getPw2() {
		return pw2;
	}public void setId(String id) {
		this.id = id;
	}public void setIdx(int idx) {
		this.idx = idx;
	}public void setPw(String pw) {
		this.pw = pw;
	}public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
}
