package myPage.dto;

import java.sql.Date;

public class commentDto {
	private int idx;
	private int mem_idx;
	private String c_title;
	private Date reg_date;
	private String content;
	private String blind;

	public commentDto(int idx, int mem_idx,String c_title, Date reg_date, String content, String blind) {
		this.idx = idx;
		this.mem_idx = mem_idx;
		this.c_title= c_title;
		this.reg_date = reg_date;
		this.content = content;
		this.blind = blind;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBlind() {
		return blind;
	}
	public void setBlind(String blind) {
		this.blind = blind;
	}
}
