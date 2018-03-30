package myPage.dto;

public class MemberDto {

	private String name;
	private String add1;
	private String add2;
	private String pw;
	private String br;
	
	public MemberDto(String name, String add1, String add2, String pw, String br) {
		this.name = name;
		this.add1 = add1;
		this.add2 = add2;
		this.pw = pw;
		this.br = br;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getBr() {
		return br;
	}
	public void setBr(String br) {
		this.br = br;
	}
}
