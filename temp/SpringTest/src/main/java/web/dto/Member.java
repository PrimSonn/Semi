package web.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private int idx;
	private String name;
	private String email;
	private String phone;
	private Date joinDate;
	
	@Override
	public String toString() {
		return "Member [ idx: "+idx+" name: "+name+" email: "+email+" phone: "+phone+" joinDate: "+joinDate+" ]";
	}
	
	public String getEmail() {
		return email;
	}public int getIdx() {
		return idx;
	}public Date getJoinDate() {
		return joinDate;
	}public String getName() {
		return name;
	}public String getPhone() {
		return phone;
	}public void setEmail(String email) {
		this.email = email;
	}public void setIdx(int idx) {
		this.idx = idx;
	}public void setJoinDate(Date joinDate) {
//		if(joinDate!=null) {
//			DateFormat formatter = new SimpleDateFormat("YYYY/MM/dd");
//			this.joinDate = formatter.format(joinDate);
//		} else {
//			this.joinDate="no joinDate";
//		}
		this.joinDate=joinDate;
	}public void setName(String name) {
		this.name = name;
	}public void setPhone(String phone) {
		this.phone = phone;
	}
}
