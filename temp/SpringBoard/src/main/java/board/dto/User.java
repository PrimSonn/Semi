package board.dto;

public class User {
	
	private String userId;
	private String userPw;
	private String userNick;
	private String email;
	private String phone;
	
	@Override
	public String toString() {
		return "USER [ id: "+userId+" pw: "+userPw+" nick: "+userNick+" email: "+email+" phone: "+phone+" ]";
	}
	
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getId() {
		return userId;
	}
	public void setId(String id) {
		this.userId = id;
	}
	public String getPw() {
		return userPw;
	}
	public void setPw(String pw) {
		this.userPw = pw;
	}
	public String getNick() {
		return userNick;
	}
	public void setNick(String nick) {
		this.userNick = nick;
	}
}
